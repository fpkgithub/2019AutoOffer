package swordoffer.Sixchapter;

import java.util.Arrays;

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
