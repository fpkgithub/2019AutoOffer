package ThreadSource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

/**
 * 两个线程打印1 2 3 4 .... 100怎么实现，一次打印
 */
public class 两个线程交替打印
{
    private static int num = 0;
    // 以A开始的信号量,初始信号量数量为1
    static Semaphore semaphore1 = new Semaphore(1);
    //// B，A完成后开始,初始信号数量为0
    static Semaphore semaphore2 = new Semaphore(0);

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
                while (num < 99)
                {
                    semaphore1.acquire();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                    System.out.println(Thread.currentThread().getName() + " : " + (++num));
                    semaphore2.release();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
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
                while (num < 100)
                {
                    semaphore2.acquire();// B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                    System.out.println(Thread.currentThread().getName() + " : " + (++num));
                    semaphore1.release();// A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
