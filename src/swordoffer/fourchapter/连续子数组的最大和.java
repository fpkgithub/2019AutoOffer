package swordoffer.fourchapter;

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
