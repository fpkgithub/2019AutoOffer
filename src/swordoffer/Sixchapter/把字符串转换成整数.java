package swordoffer.Sixchapter;

/**
 * 面试题67：把字符串转换成整数
 * 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
 */
public class 把字符串转换成整数 {
    public static void main(String[] args) {
        String str = "+2147483647";
        int res = StrToInt(str);
        System.out.println(res);


    }

    private static int StrToInt(String str) {
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char C = str.charAt(i);
            if (i == 0 && (C == '+' || C == '-')) {
                if (C == '-') {
                    flag = true;
                }
                continue;
            }
            if (C < '0' || C > '9') {
                return 0;
            }
            res = res * 10 + (C - '0');
        }
        return flag ? -res : res;
    }
}
