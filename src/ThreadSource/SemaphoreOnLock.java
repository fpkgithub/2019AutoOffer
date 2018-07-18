package ThreadSource;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//使用了共同的即基类 AbstractQueuedSynchronizer(AQS)
//AQS：是一个用于构建所和同步器的框架，许多同步器都可以通过AQS很容易并且高效的构造出来，
//不仅ReentrantLock和Semaphore是基于AQS构建的，还包括ReentrantReadWriteLock、SynchronousQueue、和FutureTask
//AQS解决了在实现同步器时涉及的大量细节问题，例如等待线程采用FIFO队列操作顺序，在不同的同步器中，
//还可以定义一些灵活的标准，来判断某个线程是应该通过，还是需要等待
public class SemaphoreOnLock
{
    private final Lock lock = new ReentrantLock();
    private final Condition permitsAvailable = lock.newCondition();
    private int permits;

    public SemaphoreOnLock(int initialPermits)
    {
        lock.lock();
        try
        {
            permits = initialPermits;
        } finally
        {
            lock.unlock();
        }
    }

    public void acquire() throws InterruptedException
    {
        lock.lock();
        try
        {
            while (permits <= 0)
            {
                permitsAvailable.await();
            }
            permits++;
        } finally
        {
            lock.unlock();
        }
    }

    public void release()
    {
        lock.lock();
        try
        {
            ++permits;
            permitsAvailable.signal();
        } finally
        {
            lock.unlock();
        }
    }
}
