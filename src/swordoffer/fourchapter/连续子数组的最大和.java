package swordoffer.fourchapter;

/**
 * 面试题42：连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
 * 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * <p>
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）。
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {

        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        //int res = FindGreatestSumOfSubArray(arr);
        int res = FindGreatestSumOfSubArray2(arr);
        System.out.println(res);

    }

    private static int FindGreatestSumOfSubArray2(int[] array) {

        if (array.length == 0 || array == null)
            return 0;
        int curSum = array[0];//记录当前所有子数组的和的最大值
        int maxSum = 0;//包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            maxSum = Math.max(curSum + array[i], array[i]);
            curSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }


    //思路：最大的子数组和   累加的子数组和
    public static int FindGreatestSumOfSubArray(int[] array) {

        if (array.length == 0 || array == null)
            return 0;
        int curSum = 0;//累加的子数组和
        int MaxSum = Integer.MIN_VALUE;//最大的子数组和
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0)//为负数时，抛弃之前的值，重新赋值
                curSum = array[i];
            else //为正数时则累加
                curSum += array[i];
            if (curSum > MaxSum)
                MaxSum = curSum;
        }
        return MaxSum;
    }
}
