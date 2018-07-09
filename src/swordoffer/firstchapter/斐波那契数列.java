package swordoffer.firstchapter;


/**
 * 求菲波那契数列的第 n 项，n <= 39。
 * f(n) = f(n-1) + f(n-2)
 * n=0 0
 * n=1 1
 * n=2 1
 * n=3 2
 * n=4 3
 */
public class 斐波那契数列
{

    public static void main(String[] args)
    {
        int num = 39;
        int res = getRes(num);
        System.out.println(res);

        int res2 = getRes2(num);
        System.out.println(res2);
    }

    private static int getRes2(int num)
    {
        if (num <= 0)
            return 0;
        if (num == 1 || num == 2)
            return 1;

        int fn1 = 1;
        int fn2 = 1;


        //f(n) = f(n-1) + f(n-2)
        //f(4) = f(2) + f(3)
        //f(5) = f(3) + f(4)

        while (num-- > 2)
        {
            fn1 = fn1 + fn2;
            fn2 = fn1 - fn2;
        }
        return fn1;
    }


    //递归
    private static int getRes(int num)
    {
        if (num == 0)
            return 0;
        if (num == 1)
            return 1;
        return getRes(num - 1) + getRes(num - 2);
    }

}
