package ThreadSource.SynchronizationLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static ThreadSource.SynchronizationLocks.ConcurrentUtils.stop;

/**
 * 隐式锁：Synchronized
 * 我们如何并发的访问那些共享的变量
 * 假设我们打算用多个线程来并发地增加一个数字
 * https://www.jianshu.com/p/053150087cd5
 */
public class SynchronizedTest
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //Stream API是JAVA函数式编程中的一个重要组成部分。
        IntStream.range(0, 1000).forEach(i -> executor.submit(SynchronizedTest::incrementSync));

        stop(executor);

        System.out.println(count);
    }

    static int count = 0;

    public static void increment()
    {
        count = count + 1;
    }

    // synchronized:
    //可重入锁 ，内部使用monitor来进行管理，monitor也被称作 monitor lock 或 intrinsic lock.
    //monitor是和对象关联在一起的,每个 synchronized的方法,针对一个对象,都使用同一个monitor
    static synchronized void incrementSync()
    {
        count = count + 1;
    }
}
