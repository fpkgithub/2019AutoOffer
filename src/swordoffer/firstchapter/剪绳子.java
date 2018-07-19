package swordoffer.firstchapter;

/**
 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 */
public class 剪绳子
{

    public static void main(String[] args)
    {
        int num = 50;

        //        double a = 1.023;
        //        int b = (int) a;

        //动态规划解法
        int res = integerBreak(num);
        System.out.println(res);

        //贪心算法
        int res2 = integerBreak2(num);
        System.out.println(res2);
    }

    private static int integerBreak(int len)
    {
        //记录最优解
        int max = 0;

        if (len < 2)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;

        //为什么要加1 是为了整齐从1开始
        //存储最优解在数组res中
        int[] res = new int[len + 1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;

        //f(n) = max(f(i)*f(n-i))
        //n 剪一刀 则有n-1中可能，也就是说剪出来的第一段绳子的可能长度分别为1,2...n-1
        for (int i = 4; i <= len; i++)
        {
            max = 0;
            //对称
            for (int j = 1; j <= i / 2; j++)
            {
                int r = res[j] * res[i - j];
                if (r > max)
                    max = r;
                //存储最优解到数组中
                res[i] = max;
            }

        }
        max = res[len];
        return max;
    }

    private static int integerBreak2(int len)
    {
        if (len < 2)
            return 0;
        if (len == 2)
            return 1;
        if (len == 3)
            return 2;

        //尽可能多地剪去长度为3的绳子段
        int timesOf3 = len / 3;
        //当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段，
        //此时更好的方法是把绳子剪成长度为2的两段，因为 2*2 > 1*3
        if (len - timesOf3 * 3 == 1)
            timesOf3 = timesOf3 - 1;
        int timesOf2 = (len - timesOf3 * 3) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}
