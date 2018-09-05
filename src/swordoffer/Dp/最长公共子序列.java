package swordoffer.Dp;

import java.util.Scanner;

/**
 * 最长公共子序列不连续
 */
public class 最长公共子序列 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);


        //链接：https://www.nowcoder.com/questionTerminal/9ae56e5bdf4f480387df781671db5172

        //String str1 = "1A2C3D4B56";
        //String str2 = "B1D23CA45B6A"; //最长公共子序列不连续：输出6
        String str1 = "ablmnopvt";
        String str2 = "abcsamnopvtvqrstuvw";//输出:mnopvt
        System.out.println(getLongestCommonSequence(str1, str2));
        System.out.println(getLongestCommonSequence2(str1, str2));//yes
        System.out.println(getLongestCommonSequence3(str1, str2));//yes

        in.close();

    }

    //最长公共子序列不连续
    //https://blog.csdn.net/heart_love/article/details/50804301
    //c[i][j]的值只取决于c[i-1][j-1]、c[i-1][j]、c[i][j-1]这三项
    private static int getLongestCommonSequence(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0) {
            return 0;
        }

        int[][] dp = new int[lenA + 1][lenB + 1];//从1开始

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lenA][lenB];
    }

    //最长公共子序列不连续
    private static int getLongestCommonSequence2(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0) {
            return 0;
        }

        int[][] dp = new int[lenA + 1][lenB + 1];//从1开始

        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[lenA][lenB];
    }

    //最长公共子序列连续
    private static int getLongestCommonSequence3(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0) {
            return 0;
        }

        int[][] dp = new int[lenA + 1][lenB + 1];//从1开始
        int max = -1;

        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (a.charAt(i) == b.charAt(j)) {

                    dp[i + 1][j + 1] = dp[i][j] + 1;

                    if (dp[i + 1][j + 1] > max)
                        max = dp[i + 1][j + 1];
                }
            }
        }
        return max;
    }
}
