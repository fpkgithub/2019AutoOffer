package ThreadSource.LockCondition;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//显式的Condition对象
public class Task
{
    private final Lock lock = new ReentrantLock();

    //add数据
    private final Condition addCondition = lock.newCondition();

    //读取数据
    private final Condition subCondition = lock.newCondition();

    private static int num = 0;

    private List<String> lists = new LinkedList<>();

    public void add()
    {
        lock.lock();
        try
        {
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

    public void sub()
    {
        lock.lock();
        try
        {
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
