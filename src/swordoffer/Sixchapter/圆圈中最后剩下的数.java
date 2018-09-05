package swordoffer.Sixchapter;

import java.util.ArrayList;

/**
 * 面试题62：圆圈中最后剩下的数字
 * 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
public class 圆圈中最后剩下的数 {
    public static void main(String[] args) {

        int n = 5;
        int m = 3;
        System.out.println(lastRemaining2(n, m));

    }

    //约瑟夫环问题：递归和非递归问题
    private static int lastRemaining(int n, int m) {
        if (n == 0)
            return -1;
        if (n == 1)
            return 0;
        //每次都是取余数
        return (lastRemaining(n - 1, m) + m) % n;//n-1的问题

    }

    private static int lastRemaining2(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = -1;
        while (list.size() != 1) {
            index = (index + m) % list.size();
            list.remove(index);
            index--;
        }
        return list.get(0);
    }
}
