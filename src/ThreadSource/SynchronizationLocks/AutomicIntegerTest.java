package ThreadSource.SynchronizationLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static ThreadSource.SynchronizationLocks.ConcurrentUtils.stop;

/**
 * AutomicInteger类：只想并发的对一个共享变量进行操作,那使用这些原子性的类
 * java.concurrent.atomic**包中,提供了大量的有用的类,来执行原子性的操作.原子性的意思是
 * 所有的操作要不就都执行成功,要不就都不执行成功
 */
public class AutomicIntegerTest
{
    public static void main(String[] args)
    {
        //incrementAndGet()方法，是线程安全的
        //incrementAndGetTest();

        //updateAndGet()方法
        //updateAndGetTest();

        //accumulateAndGet()方法
        accumulateAndGetTest();
    }

    private static void incrementAndGetTest()
    {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //通过使用AutomicInteger类型,而不是 Integer类型,我们能够以线程安全的方式,来并发的修改一个数值.
        //而不需要跟以前一样,使用 synchronized关键字或者显式锁.
        //utomicInteger类型提供的 incrementAndGet()方法,是线程安全的,所以我们可以放心的在多个线程中使用这个方法,而不需要担心那些预料之外的事情发生.
        IntStream.range(0, 1000).forEach(i -> executor.submit(atomicInteger::incrementAndGet));

        stop(executor);
        System.out.println(atomicInteger.get()); // ->1000
    }

    private static void updateAndGetTest()
    {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000).forEach(i ->
        {
            Runnable task = () -> atomicInteger.updateAndGet(n -> n + 2);
            executor.submit(task);
        });

        stop(executor);
        System.out.println(atomicInteger.get()); // ->2000
    }

    //并发的计算0到1000的和
    private static void accumulateAndGetTest()
    {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);


        IntStream.range(0, 1000).forEach(i ->
        {
            Runnable task = () -> atomicInteger.accumulateAndGet(i, (n, m) -> n + m);
            executor.submit(task);
        });

        stop(executor);
        System.out.println(atomicInteger.get()); // ->499500
    }
}
