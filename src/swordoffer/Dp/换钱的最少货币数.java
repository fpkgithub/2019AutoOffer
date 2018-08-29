package swordoffer.Dp;

public class 换钱的最少货币数 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3};
        //int[] arr = {5, 2, 5, 3};
        int aim = 20;
        int res = minCoins1(arr, aim);
        int res2 = minCoins2(arr, aim);
        System.out.println(res);
        System.out.println(res2);
    }

    private static int minCoins2(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        int len = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[len][aim + 1];//0 - aim
        //dp[0][0,1,2,3...aim]  将第一行其他的设为max，将dp[0][arr[0]] = 1
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
        }
        //dp矩阵的第一行的值只能表示使用一张arr[0]货币的情况下，找某个钱数的最小张数
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }

        //左上角某个位置的值
        int leftUp = 0;
        //剩下的位置一次从左到右，从上到下计算，计算位置为(i,j)
        //dp[i-1][j]：代表在可以任意使用arr[0..i-1][]货币的情况下，组成j所需要的最小张数（不包括使用arr[i]的货币）
        //dp[i-1][j-arr[i]]：代表在可以任意使用arr[0..i-1][]货币的情况下，组成j-arr[i-1]所需的最小张数，
        //从钱数j-arr[i]到钱数j，只需要加上当前的这张arr[i]即可，(dp[i-1][j-arr[i]] + 1)
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= aim; j++) {
                leftUp = max;
                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
                    leftUp = dp[i - 1][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(leftUp, dp[i - 1][j]);
            }
        }

        return dp[len - 1][aim] != max ? dp[len - 1][aim] : -1;
    }

    private static int minCoins1(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int len = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[len][aim + 1];

        //dp的第一行的值
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }

        int left = 0;
        //按照行来循环
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[len - 1][aim] != max ? dp[len - 1][aim] : -1;
    }
}
