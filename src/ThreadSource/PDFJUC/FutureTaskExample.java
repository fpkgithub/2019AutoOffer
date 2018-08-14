package ThreadSource.PDFJUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask可用于异步获取执行结果或取消执行任务的场景。
 * 当一个计算任务需要 执行很长时间，那么就可以用FutureTask来封装这个任务，
 * 主线程在完成自己的 任务之后再去获取结果。
 */
public class FutureTaskExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {

            int result = 0;
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                result += i;
            }
            return result;
        });*/

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;

            }
        });


        Thread compute = new Thread(futureTask);
        compute.start();

        Thread otherThread = new Thread(() -> {
            System.out.println("other task is runing...");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        otherThread.start();
        System.out.println(futureTask.get());


    }

}
