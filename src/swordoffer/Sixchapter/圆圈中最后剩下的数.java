package swordoffer.Sixchapter;

/**
 * 面试题62：圆圈中最后剩下的数字
 * 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
public class 圆圈中最后剩下的数 {
    public static void main(String[] args) {

        int n = 5;
        int m = 3;
        System.out.println(lastRemaining(n, m));

    }

    private static int lastRemaining(int n, int m) {
        if (n == 0)
            return -1;
        if (n == 1)
            return 0;
        //每次都是取余数
        return (lastRemaining(n - 1, m) + m) % n;//n-1的问题

    }
}
