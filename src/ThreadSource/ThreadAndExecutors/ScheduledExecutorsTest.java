package ThreadSource.ThreadAndExecutors;

import java.sql.Time;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 重复运行很多次,或者定时执行,使用Scheduled Executors
 * 下面的代码,会在三秒后,启动一个线程来执行任务
 */
public class ScheduledExecutorsTest
{
    public static void main(String[] args) throws InterruptedException
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        Runnable task = () -> System.out.println("Schelduling: " + System.nanoTime());

        //schedule()方法,会返回一个 ScheduleFuture,相对于普通的 Future来说,它增加了一个 getDelay法,来查看还剩多少时间来启动线程执行任务.
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MICROSECONDS.sleep(1337);

        //long remainingDelay = future.getDelay(TimeUnit.MICROSECONDS);
        //System.out.printf("Remaining Delay: %sms\n", remainingDelay);

        //ScheduleExecutorService提供了 scheduleAtFixedRate()和 scheduleWithFixedDelay()这两个方法.
        // 前者会按一定的频率来执行任务.下面的例子会每秒执行一次任务
        int initialDelay = 0;
        int period = 5;
        ScheduledFuture<?> future2 = executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);

        //scheduleWithFixedDelay:是一个任务完成后,再过多久才执行下一个任务
        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

    }
}
