package swordoffer.fourchapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 面试题40：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 */
public class 最小的K个数 {
    public static void main(String[] args) {

        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> res = findLastK(arr, 4);
        for (Integer re : res) {
            System.out.print(re + " ");
        }

    }

    private static ArrayList<Integer> findLastK(int[] arr, int num) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return list;
        for (int i = 0; i < num; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            list.add(arr[i]);
        }

        return list;

    }
}
