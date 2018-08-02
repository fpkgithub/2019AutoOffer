package ThreadSource.SynchronizationLocks;

public class SynchronizedMain {

    public static synchronized void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {
            public void run() {
                Right();
            }
        };

        t.start();

        System.out.print("Left");


        float f[][] = new float[6][];
        float[] f2[] = new float[6][];


    }

    static synchronized void Right() {
        System.out.print("Right");
    }
}
