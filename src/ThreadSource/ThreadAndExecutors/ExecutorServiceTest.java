package ThreadSource.ThreadAndExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest
{
    public static void main(String[] args)
    {
        //Executors是一个工厂类,我们可以用它来创建各种各样的 Executor Service
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() ->
        {
            try
            {
                //输出的结果很容易理解.你可能会注意到,这个程序一直在运行
                String threadName = Thread.currentThread().getName();
                //ExecutorService提供了两个方法,让我们停掉 Executor.一个是 shutdown(),它会等待当前正在运行的任务停止.
                //另一个是 shutdownNow(),它会中断全部的正在运行的任务,并让 Executor立即停止.
                executor.shutdown();
                System.out.println("Hello:" + threadName);
                executor.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e)
            {
                System.out.println("tasks interrupted");
            } finally
            {
                if (!executor.isTerminated())
                {
                    System.out.println("cancel non-finished tasks");
                }
                executor.shutdownNow();
                System.out.println("shutdown finished");
            }
        });
    }
}
