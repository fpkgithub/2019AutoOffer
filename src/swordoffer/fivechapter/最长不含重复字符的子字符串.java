package swordoffer.fivechapter;

import java.util.Arrays;

/**
 * 48：
 * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
 */
public class 最长不含重复字符的子字符串 {

    public static void main(String[] args) {

        String str = "arabcacfr";
        int res = longestSubStringWithoutDuplication(str);
        System.out.println(res);
    }

    private static int longestSubStringWithoutDuplication(String str) {
        int maxLen = 0;
        int curLen = 0;
        int[] preIndexs = new int[26];
        //Arrays.fill(preIndexs, -1);
        for (int i = 0; i < 26; i++) {
            preIndexs[i] = -1;
        }

        //i 代表当前的字符位置
        for (int i = 0; i < str.length(); i++) {
            int C = str.charAt(i) - 'a';
            int pre = preIndexs[C];
            //f(i) = f(i-1) + 1;
            //i - pre : 表示当前的字符距离上次出现的位置的距离  例如：arabcacfr  最后一个字符r的出现位置是8 上一次是1  8-1=7 > 3
            if (pre == -1 || i - pre > curLen) {
                curLen++;
            }
            //出现的位置距离小于等于f(i-1)   arab   a: 距离为2 f(2) = f(1) + 1
            else {
                maxLen = Math.max(maxLen, curLen);
                curLen = i - pre; //重新计算距离
            }
            preIndexs[C] = i;
        }
        Math.max(maxLen, curLen);
        return maxLen;
    }

}
