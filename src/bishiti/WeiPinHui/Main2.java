package bishiti.WeiPinHui;

import java.util.Scanner;

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 输入：
 * 1101 1100
 * 输出：
 * 11001
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

        System.out.println(sum2(str1, str2));
        scanner.close();
    }

    private static String sum2(String str1, String str2) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = str1.length();
        int j = str2.length();

        while (i > 0 || j > 0 || carry == 1) {
            if (i > 0) {
                carry = carry + str1.charAt(--i) - '0';
            }
            if (j > 0) {
                carry = carry + str2.charAt(--j) - '0';
            }
            sb.append((char) ((carry % 2) + '0'));
            //无符号的位移处理
            carry >>>= 1;
        }
        return sb.reverse().toString();
    }
}
