package swordoffer.firstchapter;

/**
 * 面试题2：实现Singleton模式
 * 题目：设计一个类，我们只能生成该类的一个实例。
 */
public class 实现Singleton模式
{
    private static 实现Singleton模式 singleton = null;

    //饿汉式-线程安全
    private static 实现Singleton模式 singleton2 = new 实现Singleton模式();

    public 实现Singleton模式()
    {

    }


    //懒汉式-线程不安全
    public static 实现Singleton模式 getInstance()
    {
        if (singleton == null)
            singleton = new 实现Singleton模式();

        return singleton;
    }

    //懒汉式-线程安全
    public static synchronized 实现Singleton模式 getInstance2()
    {

        if (singleton == null)
            singleton = new 实现Singleton模式();

        return singleton;
    }

    //双重检验锁
    public static synchronized 实现Singleton模式 getInstance3()
    {
        if (singleton == null)
        {
            synchronized (实现Singleton模式.class)
            {
                singleton = new 实现Singleton模式();
            }
        }

        return singleton;
    }

}
