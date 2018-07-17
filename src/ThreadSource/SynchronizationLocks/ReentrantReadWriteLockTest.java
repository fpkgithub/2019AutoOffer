package ThreadSource.SynchronizationLocks;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁来包装Map
 */
public class ReentrantReadWriteLockTest
{
    private final Map<String, Integer> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock r = lock.readLock();
    private final Lock w = lock.writeLock();

    public ReentrantReadWriteLockTest(Map<String, Integer> map)
    {
        this.map = map;
    }


    public Integer put(String key, Integer value)
    {
        w.lock();
        try
        {
            return map.put(key, value);
        } finally
        {
            w.unlock();
        }
    }
    //对remove() putAll() clear()等方法执行相同的操作

    public Integer get(Object key)
    {
        r.lock();
        try
        {
            return map.get(key);
        } finally
        {
            r.unlock();
        }
    }


}
