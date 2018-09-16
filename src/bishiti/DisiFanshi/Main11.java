package bishiti.DisiFanshi;

import java.util.Scanner;

//https://blog.csdn.net/Lynn_Baby/article/details/80757305

/**
 * 给定两个数字字符串求它们的乘积
 * 输入：
 * 123
 * 20
 *
 * 输出：
 * 2460
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num1 = scanner.next();
        String num2 = scanner.next();
        System.out.println(getMultiply(num1, num2));
        scanner.close();
    }

    public static String getMultiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;
            int carry = d[i] / 10;
            sb.insert(0, digit);
            if (i < d.length - 1) {
                d[i + 1] += carry;
            }
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
