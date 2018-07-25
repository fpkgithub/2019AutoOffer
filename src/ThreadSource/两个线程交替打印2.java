package ThreadSource;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 两个线程交替打印2
{
    private static int num = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();


    public static void main(String[] args)
    {
        new ThreadA().start();
        new ThreadB().start();
    }


    static class ThreadA extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                lock.lock();
                while (num <= 99)
                {
                    while (num % 2 != 1)//注意这里是不等于0，也就是说在count % 2为0之前，当前线程一直阻塞状态
                    {
                        condition1.await();//A释放lock锁  一直阻塞中
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    num++;
                    // A执行完唤醒B线程
                    condition2.signal();
                }

            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread
    {
        @Override
        public void run()
        {
            try
            {
                lock.lock();
                while (num <= 100)
                {
                    while (num % 2 != 0)//注意这里是不等于0，也就是说在count % 2为0之前，当前线程一直阻塞状态
                    {
                        condition2.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    num++;
                    // A执行完唤醒B线程
                    condition1.signal();// B执行完唤醒A线程
                }

            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock();
            }
        }
    }

}
