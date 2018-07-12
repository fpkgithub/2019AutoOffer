package swordoffer.firstchapter;

/**
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 */
public class 矩形覆盖
{
    public static void main(String[] args)
    {
        int n = 10;
        int res = getCount(n);
        System.out.println(res);

        int res2 = getCount2(n);
        System.out.println(res2);

        int res3 = getCount3(n);
        System.out.println(res3);
    }

    //复杂度：O(N) + O(N)
    private static int getCount3(int n)
    {
        if (n <= 2)
            return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }


    //复杂度：O(N) + O(1)
    private static int getCount2(int n)
    {

        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        int f1 = 1;
        int f2 = 2;
        int f3 = 0;

        while (n-- > 2)
        {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;

    }


    //


    //递归
    //1 1
    //2 2
    //3 3
    //4 5
    private static int getCount(int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return getCount(n - 1) + getCount(n - 2);
    }
}
