package ThreadSource.SynchronizationLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static ThreadSource.SynchronizationLocks.ConcurrentUtils.stop;
import static java.lang.Thread.sleep;

/**
 * 信号量,锁通常用于互斥的访问某些资源,而信号量用于限制一定的线程可以同时访问某些资源
 */
public class SemaphoresTest
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(5);

        Runnable longRunningTask = () ->
        {
            boolean permit = false;
            try
            {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit)
                {
                    System.out.println("Semaphore acquired");
                    sleep(5000);
                }
                else
                {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                if (permit)
                    semaphore.release();
            }
        };

        //十个线程,但是因为我们将信号量设置成了5.所以实际上,只有5个线程有机会来执行操作.
        //只有前五个线程,能够获得一个信号量,然后来执行暂停五分钟的操作.其他的线程,因为没有信号量可以获取了,就只能在控制台打印处** Could not acquire semaphore**.
        IntStream.range(0, 10).forEach(i -> executor.submit(longRunningTask));
        //stop(executor);
    }
}
