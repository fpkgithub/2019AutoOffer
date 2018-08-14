package ThreadSource.两个线程交替打印;

//错误的
public class YieldMethdod {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        a.setPriority(2);
        b.setPriority(1);
        a.start();
        b.start();

    }

}

class A extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            if (i % 2 != 0) {

                System.out.println("A:" + Thread.currentThread().getName() + ":" + i);
                Thread.yield();
            }
        }
    }
}

class B extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println("B:" + Thread.currentThread().getName() + ":" + i);
                Thread.yield();

            }
        }
    }
}