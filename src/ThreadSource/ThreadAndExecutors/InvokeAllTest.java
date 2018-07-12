package ThreadSource.ThreadAndExecutors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//invokeAll等线程任务执行完毕后,取得全部任务的结果值。
//Executor Service支持通过调用 invokeAll()方法,来传入多个 Callable,
// 实现一次执行多个任务的目的.这个方法,其参数是 Callable的集合,其返回值,是 Future对象的集合
public class InvokeAllTest
{
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");

        executor.invokeAll(callables).stream().map(future ->
        {
            try
            {
                return future.get();
            } catch (Exception e)
            {
                throw new IllegalStateException(e);
            }
        }).forEach(System.out::println);

    }
}
