package bishiti.DisiFanshi;

import java.util.Scanner;

/**
 * 给定一个字符串，找出最长的对称子串（如有多个则任意输出一个）
 * 输入：abbaad
 * 输出：abba
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String str = scanner.nextLine();
        getMaxHuiWen("abbaad");
        scanner.close();
    }

    /*
     * 最长回文子串(动态规划解决方法)
     * 思路:pal数组标记位于j~i之间串是否为回文子串
     * 若判断j~i间是否为回文子串，需依赖于 j+1 ~ i-1间子串类型，依此类推
     * 直到依赖项为x或者xy,(x,y未知)(仔细体会为什么是这样)
     * i-j<2 :用于判断x或者xy的情况,当然不要忽略&&的短路效应
     */
    public static int longestPalindrome(String str) {
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int begin = -1;//记录最长的开始位置
        int temp = -1;
        //例如：abbaad   输出为：abba
        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                //判断子串就j -- i之间的字符   i-j<2判断x或者xy的情况  dp[j+1][i-1]判断上一个是否含有回文
                if (str.charAt(i) == str.charAt(j) && (i - j < 2 || dp[j + 1][i - 1] == true)) {
                    dp[j][i] = true;
                    temp = maxLen;
                    maxLen = Math.max(maxLen, i - j + 1);
                    if (temp != maxLen) {
                        begin = j;
                    }
                }
            }
        }
        System.out.println(str.substring(begin, begin + maxLen));
        return maxLen;
    }

    /**
     * 分析：
     * 有两种可能，一种是回文字符串的长度为奇数，一种是偶数的情况。
     * i为字符串当前字符的下标。
     * 当回文字串为奇数的时候，j表示i-j与i+j构成的回文字串长度；
     * 当回文字串长度为偶数的时候，j表示i+1左边j个字符一直到i右边j个字符的回文字串长度
     * 用max保存遍历结果得到的最大值并且输出
     */

    //https://blog.csdn.net/HL_HLHL/article/details/79749153

    /**
     * <---- i-j   i   i+j  -->
     * I s   P A T & T A P   s y m m e t r i c
     * 0 1 2 3 4 5 6 7 8 8 9 10
     */

    private static void getMaxHuiWen(String str) {
        int len = str.length();
        int maxLen = 0;
        int temp = 1;
        for (int i = 1; i < len; i++) {

            temp = 1;
            //当为奇数时
            int j = 1;
            for (; j < len; j++) {
                if (i - j < 0 || i + j >= len || str.charAt(i - j) != str.charAt(i + j))
                    break;
                //符合条件则＋2
                temp = temp + 2;
            }
            maxLen = Math.max(temp, maxLen);

            //为偶数时
            temp = 0;
            j = 1;
            for (; j < len; j++) {
                if (i - j + 1 < 0 || i + j >= len || str.charAt(i - j + 1) != str.charAt(i + j))
                    break;
                temp = temp + 2;
            }
            maxLen = Math.max(maxLen, temp);
        }
        System.out.println(maxLen);
        //System.out.println(str.substring(begin, maxLen));
        System.out.println();
    }


}
