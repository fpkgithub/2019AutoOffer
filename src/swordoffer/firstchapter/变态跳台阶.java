package swordoffer.firstchapter;

import java.util.Arrays;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级...
 * 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 */
public class 变态跳台阶
{
    public static void main(String[] args)
    {
        int n = 10;
        int res = fun(n);
        System.out.println(res);
    }


    //f(1) = 1
    //f(2) = f(2-1) + f(2-2)        
    //f(3) = f(3-1) + f(3-2) + f(3-3) 
    //f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n) 

    //f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
    //f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)
    //可以得出：
    //f(n) = 2*f(n-1)

    /*
           | 1       ,(n=0 )

    f(n) = | 1       ,(n=1 )

           | 2*f(n-1),(n>=2)
    */

    //1 1
    //2 2
    //3 3
    private static int fun(int n)
    {
        if (n <= 0)
            return -1;
        else if (n == 1)
            return 1;
        else
            return 2 * fun(n - 1);
    }
}
