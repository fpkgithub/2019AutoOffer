package swordoffer.firstchapter;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class 跳台阶
{

    public static void main(String[] args)
    {
        int n = 4;
        int res = fun(n);
        System.out.println(res);
        int res2 = fun2(n);
        System.out.println(res2);

    }

    //f(6) = f(5) + f(4)
    //复杂度：O(N) + O(1)
    private static int fun2(int n)
    {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int fn1 = 1;
        int fn2 = 2;
        int fn3 = 0;
        while (n-- > 2)
        {
            fn3 = fn1 + fn2;
            fn1 = fn2;
            fn2 = fn3;

        }

        return fn3;
    }

    //1  1
    //2  2
    //3  3
    //4  5
    private static int fun(int n)
    {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return fun(n - 1) + fun(n - 2);
    }
}
