package ThreadSource.ThreadAndExecutors;

import java.util.concurrent.*;

//Callable和 Runnable的区别在于, Callable是有返回值的
public class CallablesAndFutures
{
    public static void main(String[] args)
    {

        Callable<Integer> task = () ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(5);
                return 123;
            } catch (InterruptedException e)
            {
                throw new IllegalAccessException("task interrupted");
            }
        };

        //通过返回一个 Future对象,其中会封装任务的返回值.等任务完成后,我们就能通过这个 Future对象,来获取 Callable**的返回值
        //因为 submit()方法是非阻塞的,它不会等待任务完成
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);
        try
        {
            //通过 isDone()方法,来查看 Future对象是否完成
            System.out.println("future done? " + future.isDone());
            //调用get()方法,会阻塞当前线程,直到 callable执行完毕
            Integer result = future.get();
            System.out.println("future done? " + future.isDone());
            System.out.println("result:" + result);

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }


        //Future对象和 Executor Service之间,有轻微的耦合.需要注意的是,如果你在 Future完成之前,结束 Executor,那么它会抛出异常.
        //executor.shutdownNow();
        //future.get();

    }
}
