package ThreadSource.SynchronizationLocks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

import static ThreadSource.SynchronizationLocks.ConcurrentUtils.stop;
import static java.lang.Thread.sleep;

/**
 * 显式锁:Locks
 *
 * @see ReentrantLock 互斥锁 可重入
 * @see Condition
 * @see ReadWriteLock
 */
public class LocksTest
{
    public static void main(String[] args)
    {
        //ReentrantLock 互斥锁 可重入
        //ReentrantLockTest();


        //ReadWriteLock:包含一对锁,分别用于对共享变量的读和写操作
        //如果当前没有线程来修改共享变量,那么允许多个线程来访问共享变量,而没有什么危险.
        // 所以说,当没有线程持有写锁的时候,可以有多个线程持有读锁.这在那些读操作远大于写操作的场景中,极大的提高了性能和吞吐量.
        //ReadWriteLockTest();


        //StampedLock的锁,这个锁也有读锁和写锁,就跟上面的 ReadWriteLock一样.但是,和 ReadWriteLock不同,它会返回一个 long类型的值
        //我们可以通过这个值来释放锁,检查锁是否有效.另外,它还包含一种叫做乐观锁的锁
        //StampedLockTest();


        //乐观锁
        HappyLock();
    }

    private static void HappyLock()
    {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        StampedLock lock = new StampedLock();

        executor.submit(() ->
        {
            //tryOptimisticRead()方法,会获得一个乐观读锁.它总会返回一个值,而不会阻塞当前线程.如果有线程持有写锁,则返回值是0.
            long stamp = lock.tryOptimisticRead();
            try
            {
                //我们需要通过 lock.validate()方法来检查一下返回值,来确定是否真的有读锁可用.
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(1000);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                sleep(2000);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock(stamp);
            }


        });

        executor.submit(() ->
        {
            long stamp = lock.writeLock();
            try
            {
                System.out.println("Write Lock acquired");
                sleep(2000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock(stamp);
                System.out.println("write done");
            }
        });

        //读锁转换成写锁： StampedLock提供了 tryConvertToWriteLock()**这个方法,来进行转换
        //会先获取读锁,并尝试输出count变量的值.但是当其等于0时,它会将读锁转换成写锁,如果转换成功,
        //则将23赋给count.如果不成功,则直接通过** lock.writeLock()**来以阻塞的方式获取写锁.
        // 然后将23赋给count.最后,再释放锁
        executor.submit(() ->
        {
            long stamp = lock.readLock();
            try
            {
                if (count == 0)
                {
                    stamp = lock.tryConvertToWriteLock(stamp);
                    if (stamp == 0)
                    {
                        System.out.println("Could not conert to write lock");
                        stamp = lock.writeLock();
                    }
                    count = 23;
                }
                System.out.println(count);
            } finally
            {
                lock.unlock(stamp);
            }
        });

        stop(executor);
    }

    //StampedLock：没有可重入的特性
    //如果没有锁可用,则调用上面的方法,会导致返回一个值,并阻塞线程,即使当前线程已经有锁了.所以你使用这个锁的时候,要小心,别出现死锁的情况.
    private static void StampedLockTest()
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        executor.submit(() ->
        {
            //writeLock()方法来获取写锁
            long stamp = lock.writeLock();
            try
            {
                //返回一个 long类型的值
                sleep(5000);
                map.put("foo", "bar");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                //通过这个值来释放锁
                System.out.println("write done...");
                lock.unlockWrite(stamp);
            }
        });

        //跟ReadWriteLock锁一样,要获得读锁,必须等待写锁被释放
        Runnable readTask = () ->
        {
            //readLock()方法来获取读锁
            long stamp = lock.readLock();
            try
            {
                System.out.println(map.get("foo"));
                sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                System.out.println("read done...");
                lock.unlockWrite(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        stop(executor);
    }


    public static void ReadWriteLockTest()
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        executor.submit(() ->
        {
            lock.writeLock().lock();
            try
            {
                sleep(5000);
                map.put("foo", "bar");
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                System.out.println("write done...");
                lock.writeLock().unlock();
            }
        });

        //只有当写锁被释放之后,后面的线程才会同时获取到读锁.
        // 而不需要等第一个线程的读锁释放之后,第二个线程才能获取读锁.
        Runnable readTask = () ->
        {
            lock.readLock().lock();
            try
            {
                System.out.println(map.get("foo"));
                sleep(2000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                System.out.println("read done...");
                lock.readLock().unlock();
            }
        };
        executor.submit(readTask);
        executor.submit(readTask);
        stop(executor);
    }


    static ReentrantLock lock = new ReentrantLock();
    static int count = 0;

    //第一个任务获得锁,然后暂停一秒钟.而第二个任务则获取锁的当前状态,并将其输出出来.
    private static void ReentrantLockTest()
    {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();
        executor.submit(() ->
        {

            lock.lock();
            try
            {
                sleep(1);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            } finally
            {
                lock.unlock();
            }
        });

        executor.submit(() ->
        {
            System.out.println("Locked:" + lock.isLocked());
            System.out.println("Held by me:" + lock.isHeldByCurrentThread());
            // tryLock()会尝试获取锁,而不会像 lock()方法一样,阻塞线程.我们需要在执行那些需要访问共享变量的操作之前,检查一下其返回值,以防止不同步的情况.
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired:" + locked);
        });
        stop(executor);
    }

    //通过lock()方法来获得锁,而通过 unlock()方法,来释放锁.
    //只有一个线程能够同时占有锁
    private static void increment()
    {
        lock.lock();
        try
        {
            count++;
        } finally
        {
            lock.unlock();
        }
    }
}
