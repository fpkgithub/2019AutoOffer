package swordoffer.secondchapter;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串 "+100","5e2","-123","3.1416" 和 "-1E-16" 都表示数值。
 * 但是 "12e","1a3.14","1.2.3","+-5" 和 "12e+4.3" 都不是。
 */
public class 表示数值的字符串
{
    static int index = 0;

    public static void main(String[] args)
    {
        String str = "123.45E+4";
        boolean res = isNumeric(str.toCharArray());
        System.out.println(res);


        //正则表达式
        boolean res2 = isNumeric2(str);
        System.out.println(res2);
    }

    private static boolean isNumeric(char[] str)
    {
        if (str == null || str.length < 1)
            return false;

        //判断符号并取得第一个非数字的index
        boolean flag = scanInteger(str);

        //判断是否有小数点
        if (index < str.length && str[index] == '.')
        {
            index++;
            //判断小数点后的数字，直到非数字
            flag = scanUnsignedInteger(str) || flag;
        }

        //判断是否有e
        if (index < str.length && (str[index] == 'E' || str[index] == 'e'))
        {
            index++;
            //判断e后面的+ -号，以及数字
            flag = flag && scanInteger(str);
        }

        return flag && (index == str.length);
    }

    //整数的格式可以用+  - B表示, 其中B为无符号整数
    private static boolean scanInteger(char[] str)
    {
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return scanUnsignedInteger(str);
    }

    private static boolean scanUnsignedInteger(char[] str)
    {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
        {
            index++;
        }
        //判断数字，返回当前数字的索引
        return start < index;
    }

    private static boolean isNumeric2(String str)
    {
        if (str == null)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
