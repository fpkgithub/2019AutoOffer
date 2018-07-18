package ThreadSource.LockCondition;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//显式的Condition对象 : 当使用显式的Lock和Condition时，也必须满足锁，条件谓词和条件变量之间的三元关系
//内置的条件队列，Object中的wait、notify、notifyAll方法构成了内部条件队列的API 内置锁Synchronized
public class Task
{
    private final Lock lock = new ReentrantLock();

    //两个条件谓词 非满 非空
    //add数据
    private final Condition addCondition = lock.newCondition();

    //读取数据
    private final Condition subCondition = lock.newCondition();

    private static int num = 0;

    private List<String> lists = new LinkedList<>();

    public void put()
    {
        lock.lock();
        try
        {
            //阻塞直到非满
            //当集合已满,则"添加"线程等待
            while (lists.size() == 10)
            {
                //写线程等待
                addCondition.await();
            }

            num++;
            lists.add("add boy" + num);
            System.out.println("ADD：The lists size is " + lists.size());
            System.out.println("The Current Thread is " + Thread.currentThread().getName());
            System.out.println("******************************");

            //唤醒
            this.subCondition.signal();


        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }

    public void take()
    {
        lock.lock();
        try
        {
            //阻塞直到非空
            //当集合为空时,"减少"线程等待
            while (lists.size() == 0)
            {
                //当缓冲区为空时，"读线程"需要等待。
                subCondition.await();
            }

            String str = lists.get(0);
            lists.remove(0);
            System.out.println("SUB：The Boy is [" + str + "]");
            System.out.println("The current thread is " + Thread.currentThread().getName());
            System.out.println("************************");
            num--;
            addCondition.signal();

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }
    }
}
