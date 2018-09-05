package swordoffer.Sixchapter;

import java.util.ArrayList;

/**
 * 面试题57（二）：为s的连续正数序列
 * 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
 * 4～6和7～8。
 */
public class 和为S的连续正数序列 {
    public static void main(String[] args) {

        int s = 15;
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(s);

    }

    //思路：双指针技术和求和公式
    private static ArrayList<ArrayList<Integer>> FindContinuousSequence(int s) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，
        //我们根据窗口内值之和来确定窗口的位置和宽度。
        int begin = 1;
        int end = 2;
        while (begin < end) {
            //求和公式
            int sum = (begin + end) * (end - begin - 1) / 2;
            if (sum == s) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = begin; i <= end; i++) {
                    list.add(begin);
                }
                res.add(list);
                begin++;
            }
            else if (sum < s) {
                end++;
            }
            else {
                begin++;
            }
        }
        return res;
    }
}
