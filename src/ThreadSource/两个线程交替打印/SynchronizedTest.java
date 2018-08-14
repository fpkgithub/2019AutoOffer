package ThreadSource.两个线程交替打印;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {


    public SynchronizedTest() {
        System.out.println("123");
    }

    public static void main(String[] args) {

        A1 a = new A1();
        B2 b1 = new B2();
        B2 b2 = new B2();
        ExecutorService executorService = Executors.newCachedThreadPool();

        SynchronizedTest test = new SynchronizedTest();


        //executorService.execute(() -> b1.fun2());
        //executorService.execute(() -> b2.fun2());
    }


    public void fun2() {
        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class A1 {
    public void fun1() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class B2 {
    public void fun2() {
        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

}
