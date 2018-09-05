package swordoffer.Dp;

import java.util.Arrays;

/**
 * 给定一个序列 An = a1 ,a2 ,  ... , an ，找出最长的子序列使得对所有 i < j ，ai < aj 。求出这个子序列的长度
 * 输入描述:
 * 输入的序列
 * 输出描述:
 * 最长递增子序列的长度
 * 示例1
 * 输入
 * 1 -1 2 -2 3 -3 4
 * 输出
 * 4
 */
public class 最长递增子序列 {
    public static void main(String[] args) {

        int[] arr = {2, 1, 4, 3, 1, 5, 6};

        System.out.println(fun(arr));

    }

    private static int fun(int[] arr) {

        int res = 0;

        if (arr == null) {
            return res;
        }
        int len = arr.length;
        if (len <= 1) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxLen = 0;
        for (int i = 1; i < len; i++) {

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);

                    if (dp[i] > maxLen) {
                        maxLen = dp[i];
                    }
                }
            }
        }

        return maxLen;
    }
}
