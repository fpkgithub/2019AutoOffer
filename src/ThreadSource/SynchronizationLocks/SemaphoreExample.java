package ThreadSource.SynchronizationLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(3);

        //以下代码模拟了对某个服务的并发请求，每次只能有	3个客户端同时访问，请求总数为	10。
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(semaphore.availablePermits());
                        //Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        }
        service.shutdown();
    }
}
