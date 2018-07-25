package ThreadSource.两个线程交替打印;

/**
 * https://blog.csdn.net/xiaokang123456kao/article/details/77331878#t2
 * 为了控制执行的顺序，必须要先持有prev锁（也就前一个线程要释放其自身对象锁），
 * 然后当前线程再申请自己对象锁，两者兼备时打印。
 * 之后首先调用self.notify()唤醒下一个等待线程（注意notify不会立即释放对象锁，只有等到同步块代码执行完毕后才会释放），
 * 再调用prev.wait()立即释放prev对象锁，当前线程进入休眠，等待其他线程的notify操作再次唤醒。
 */
public class 两个线程交替打印3
{

    static int num = 0;

    public static class ThreadPrinter implements Runnable
    {
        //是前一个线程所对应的对象锁，其主要作用是保证当前线程一定是在前一个线程操作完成后（即前一个线程释放了其对应的对象锁）才开始执行。
        private Object prev;
        private Object self;

        public ThreadPrinter(Object prev, Object self)
        {
            this.prev = prev;
            this.self = self;
        }

        @Override
        public void run()
        {
            while (num < 100)
            {   // 多线程并发，不能用if，必须使用whil循环
                synchronized (prev) // 先获取 prev 锁
                {
                    synchronized (self) // 再获取 self 锁
                    {
                        System.out.println(Thread.currentThread().getName() + " " + (++num));// 打印

                        self.notifyAll();// 唤醒其他线程竞争self锁，注意此时self锁并未立即释放。
                    }
                    // 此时执行完self的同步块，这时self锁才释放。
                    try
                    {
                        if (num == 100)
                        {// 如果count==0,表示这是最后一次打印操作，通过notifyAll操作释放对象锁。
                            prev.notifyAll();
                        }
                        else
                        {
                            //wait()方法是Object类里面的，主要的意义就是让线程放弃当前的对象的锁，进入等待此对象的等待锁定池，
                            //只有针对此对象调动notify方法后本线程才能够进入对象锁定池准备获取对象锁进入运行状态。
                            //导致当前线程等待，直到另一个线程调用此对象的notify（）方法或notifyAll（）方法。
                            //是释放prev锁 并休眠线程，等待唤醒。
                            prev.wait();
                        }
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        Object a = new Object();
        Object b = new Object();
        ThreadPrinter pa = new ThreadPrinter(b, a);
        ThreadPrinter pb = new ThreadPrinter(a, b);

        new Thread(pa).start();
        Thread.sleep(10);// 保证初始ABC的启动顺序
        new Thread(pb).start();
        Thread.sleep(10);
    }
}