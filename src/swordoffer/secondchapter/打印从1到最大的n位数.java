package swordoffer.secondchapter;

/**
 * 输入数字 n，按顺序打印出从 1 最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class 打印从1到最大的n位数 {
    public static void main(String[] args) {
        int n = 2;

        //Ordinary(n);

        //由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
        //太啰嗦，不容易写出来
        //print1ToMaxOfNDigits(n);


        //n位数，n个0-9的全排列问题，只是在打印的时候不打印出来罢了
        print1ToMaxOfNDigits(n);

    }

    private static void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;

        StringBuffer str = new StringBuffer();

        //初始化为00...0
        for (int i = 0; i < n; i++) {
            str.append('0');
        }

        //0-9 循环
        for (int i = 0; i < 10; i++) {
            str.setCharAt(0, (char) (i + '0'));
            Print1ToMaxOfNDigitsRecursively(str, n, 0);
        }


    }

    private static void Print1ToMaxOfNDigitsRecursively(StringBuffer str, int n, int index) {
        //当到达数字的最后一位 则打印并返回
        if (index == n - 1) {
            printDigits(str);
            return;
        }

        for (int i = 0; i < 10; i++) {
            str.setCharAt(index + 1, (char) (i + '0'));
            Print1ToMaxOfNDigitsRecursively(str, n, index + 1);
        }
    }

    private static void printDigits(StringBuffer str) {
        //检索第一个为零的数字下标
        int i;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                ;
            break;
        }
        while (i < str.length()) {
            System.out.print(str.charAt(i++));
        }
        System.out.println();

        //另一个
        /*
        boolean flag = true;
        for (int j = 0; j < str.length(); j++)
        {
            if (flag && str.charAt(i) != '0')
                flag = false;
            if (!flag)
                System.out.print(str.charAt(i));
        }
        System.out.println();
        */
    }


    //没有考虑大数的问题，n的值要是很大的话，会溢出
    private static void Ordinary(int n) {
        //注意初始值为1
        int max = 1;
        int i = 0;
        while (i++ < n) {
            max *= 10;
        }
        System.out.println(max);
        for (int j = 1; j < max; j++) {
            System.out.println(j);
        }

    }
}
