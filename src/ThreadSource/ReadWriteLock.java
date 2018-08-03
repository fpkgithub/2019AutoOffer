package ThreadSource;

public class ReadWriteLock {

    private int readers = 0;
    private int writers = 0;
    private int writerRequests = 0;

    public synchronized void readLock() throws InterruptedException {

        while (writers > 0 || writerRequests > 0) {
            wait();
        }
        readers++;
    }

    public synchronized void readUnlock() {
        readers--;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {

        writerRequests++;
        while (readers > 0 || writerRequests > 0) {
            wait();
        }
        writerRequests--;
        writers++;
    }

    public synchronized void writeUnlock() {
        writers--;
        notifyAll();
    }

}
