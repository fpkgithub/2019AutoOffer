package ThreadSource.ThreadAndExecutors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

//一次执行多个任务的方法, invokeAny取得第一个方法的返回值,当第一个任务结束后，会调用interrupt方法中断其它任务。
//invokeAny()方法,这个方法和 invokeAll()方法,有一些不同.
//这个方法不会返回 Future对象,它会一直等到第一个 Callable运行结束,然后返回其返回值
public class InvokeAnyTest
{

    //生成Callable帮助类
    static Callable<String> callable(String str, long sleepSeconds)
    {
        return () ->
        {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return str;
        };
    }

    public static void main(String[] args)
    {


        //通过newWorkStealingPool()来创建了另一种 ExecutorService.这种 ExecutorService,其线程池中的线程的数量,默认为我们的机器的核数
        ExecutorService executor = Executors.newWorkStealingPool();
        //然后执行下面的代码,它会返回需要执行的时间最短的任务的返回值
        List<Callable<String>> callables = Arrays.asList(callable("task1", 2), callable("task2", 1), callable("task3", 3));
        try
        {

            String result = executor.invokeAny(callables);
            System.out.println(result);

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

    }


}
