package bishiti.Haoweilai;

import java.util.Scanner;

/**
 * 输入：
 * 5 1 3 4 9 7 6 8
 * 最大序列是：1 3 4 7 8
 * 输出：
 * 23
 */
public class Main5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr_str = str.split("\\s+");
        int[] arr = new int[arr_str.length];
        for (int i = 0; i < arr_str.length; i++) {
            arr[i] = Integer.parseInt(arr_str[i]);
        }

        int res = getSum(arr);
        System.out.println(res);

        scanner.close();

    }

    private static int getSum(int[] arr) {
        int maxValue = Integer.MIN_VALUE;

        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        else if (len == 1)
            return arr[0];
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = arr[i];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    //更新dp的值
                    if (dp[i] < dp[j] + arr[i]) {
                        dp[i] = dp[j] + arr[i];
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (maxValue < dp[i]) {
                maxValue = dp[i];
            }
        }
        return maxValue;
    }
}
