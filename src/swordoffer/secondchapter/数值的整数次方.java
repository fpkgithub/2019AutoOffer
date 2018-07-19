package swordoffer.secondchapter;

/**
 * 面试题16：数值的整数次方
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class 数值的整数次方
{
    public static void main(String[] args)
    {
        double base = 2;
        int exponent = -1;

        //常规解法 时间复杂度为 O(exponent)
        double res = powerOfInteger(base, exponent);
        System.out.println(res);


        //最优解法 时间复杂度为O(logn)
        double res2 = powerOfInteger2(base, exponent);
        System.out.println(res2);

    }

    private static double powerOfInteger2(double base, int exponent)
    {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        //false 标志 exponent为正数
        boolean flag = false;
        if (exponent < 0)
        {
            flag = true;
            exponent = -exponent;
        }

        //double res = powerOfInteger2(base * base, exponent / 2); //右移运算代替除以二 效率高
        double res = powerOfInteger2(base * base, exponent >> 1);
        //奇数 exponent & 0x1  ==  exponent %2
        if ( exponent %2 != 0)
            res = res * base;
        return flag ? 1 / res : res;
    }


    private static double powerOfInteger(double base, int exponent)
    {
        //要考虑负数，负数的情况取绝对值然后倒数；要考虑base=0的情况
        if (base == 0.0)
        {
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0)
        {
            absExponent = -exponent;
        }

        double res = power(base, absExponent);
        if (exponent < 0)
        {
            res = 1.0 / res;
        }
        return res;
    }


    private static double power(double base, int exponent)
    {
        double res = 1.0;
        for (int i = 0; i < exponent; i++)
        {
            res *= base;
        }
        return res;

    }
}
