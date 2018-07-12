package ThreadSource.SynchronizationLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static ThreadSource.SynchronizationLocks.ConcurrentUtils.stop;

/**
 * LongAddr和 AtomicLong相似,用于连续的为数值增加一个值.
 * 在执行写操作的线程多于执行读操作的线程这种情景中,比较常用,通常用在那些需要获取统计数据的情况中.比如,你想要计算服务器接受的请求数
 * 缺点是,由于要在内存中维护大量的变量,所以它比较耗内存.
 */
public class LongAddrTest
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //IntStream.range(0, 1000).forEach(i -> executor.submit(adder::increment));

        stop(executor);
        //System.out.println(adder.sumThenReset());  //  => 1000

    }
}
