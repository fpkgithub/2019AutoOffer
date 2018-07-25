package ThreadSource.两个线程交替打印;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过ReentrantLock我们可以很方便的进行显式的锁操作，即获取锁和释放锁，
 * 对于同一个对象锁而言，统一时刻只可能有一个线程拿到了这个锁，
 * 此时其他线程通过lock.lock()来获取对象锁时都会被阻塞，
 * 直到这个线程通过lock.unlock()操作释放这个锁后，其他线程才能拿到这个锁。
 */
public class 两个线程交替打印4
{
    private static Lock lock = new ReentrantLock();
    private static int num = 1;


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
            while (num < 99)
            {
                try
                {
                    lock.lock();
                    while (num % 2 == 1)// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                    {
                        System.out.println(Thread.currentThread().getName() + " " + (num++));
                    }

                } finally
                {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread
    {
        @Override
        public void run()
        {
            while (num < 100)
            {
                try
                {
                    lock.lock();
                    while (num % 2 == 0)// 多线程并发，不能用if，必须用循环测试等待条件，避免虚假唤醒
                    {
                        System.out.println(Thread.currentThread().getName() + " " + (num++));
                    }
                } finally
                {
                    lock.unlock();
                }
            }
        }
    }

}
