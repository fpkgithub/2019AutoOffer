package ThreadSource.PDFJUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }

        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }


    }

    static class Producer extends Thread {

        @Override
        public void run() {
            try {
                queue.put("Producer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer..");
        }
    }

    static class Consumer extends Thread {


        @Override
        public void run() {
            String str = null;
            try {
                str = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(str);
        }
    }

}
