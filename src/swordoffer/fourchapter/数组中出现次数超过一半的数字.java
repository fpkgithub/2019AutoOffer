package swordoffer.fourchapter;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        int res = moreThanHalfArray(nums, nums.length);
        System.out.println(res);

    }

    //方法一
    private static int moreThanHalfArray(int[] nums, int len) {

        if (nums == null || nums.length == 0)
            return 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i] == nums[i + 1])
                return nums[i];
        }
        return 0;

    }

    //方法二
    private static int moreThanHalfArrays2(int[] nums, int len) {
        if (nums == null || nums.length == 0)
            return 0;

        int reslut = nums[0];
        int times = 1;

        for (int i = 0; i < len; i++) {
            //重新初始化
            if (times == 0) {
                reslut = nums[i];
                times = 1;
            }
            else {
                //相同的数字加一
                if (nums[i] == reslut) {
                    times++;
                }
                else {
                    times--;
                }
            }
        }

        //验证：如果出现的最多数字没有超多数组长度的一半
        times = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == reslut)
                times++;
            if (times > len / 2)
                return reslut;
        }
        return 0;
    }

}