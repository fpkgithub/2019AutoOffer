package ThreadSource.ThreadAndExecutors;

import java.util.concurrent.*;

//future.get()方法,会阻塞当前线程,直到 Callable执行完毕.那如果Callable执行的是一个死循环呢?
// 这会导致我们的程序失去响应.我们可以通过设置超时时间,来解决这个问题
public class TimeoutsTest
{
    public static void main(String[] args)
    {
        Callable<Integer> task = () ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e)
            {
                throw new IllegalAccessException("task interrupted");
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException e)
            {
                throw new IllegalAccessException("task interrupted" + e);
            }
        });
        try
        {
            //设置其最多等待1秒,但是Callable执行却需要两秒
            future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        } catch (TimeoutException e)
        {
            e.printStackTrace();
        }
    }
}
