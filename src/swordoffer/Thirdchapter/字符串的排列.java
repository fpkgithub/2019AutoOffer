package swordoffer.Thirdchapter;

import java.util.*;

/**
 * 面试题38：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
 * 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
public class 字符串的排列 {
    public static void main(String[] args) {

        String str = "abc";
        ArrayList<String> res = printPermutation(str);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }

    //分两部分：
    //1：所有可能出现在第一位的字符情况
    //2：固定第一位字符，求后面所有字符的排列（递归解决）
    private static ArrayList<String> printPermutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0 || str == null)
            return res;
        //Treeset 排序和去重
        TreeSet<String> set = new TreeSet<>();
        permutation(set, str.toCharArray(), 0);
        res.addAll(set);
        //Collections.sort(res);
        return res;
    }

    private static void permutation(TreeSet<String> res, char[] arr, int curIndex) {
        if (curIndex == arr.length) {
            res.add(new String(arr));
            return;
        }

        //递归求第二部分
        for (int i = curIndex; i < arr.length; i++) {
            //换依次交换第一位
            swap(arr, i, curIndex);
            permutation(res, arr, curIndex + 1);
            //回溯
            swap(arr, i, curIndex);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        //剔除第一位的交换
        if (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
