package swordoffer.firstchapter;

/**
 * 面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class 二进制中1的个数
{
    public static void main(String[] args)
    {

        int n = 10;

        System.out.println(Integer.toBinaryString(n));

        //API
        int res1 = UseJavaApi(n);
        System.out.println(res1);


        int res2 = NumberOf1(n);
        System.out.println(res2);

        //推荐解法
        int res3 = NumberOf2(n);
        System.out.println(res3);

    }

    //
    private static int NumberOf2(int n)
    {
        int count = 0;
        while (n != 0)
        {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    private static int NumberOf1(int n)
    {
        int count = 0;
        char[] arr = Integer.toBinaryString(n).toCharArray();
        for (char c : arr)
        {
            if (c == '1')
            {
                count++;
            }
        }
        return count;
    }

    private static int UseJavaApi(int n)
    {
        return Integer.bitCount(n);
    }
}
