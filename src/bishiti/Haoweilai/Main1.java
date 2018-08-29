package bishiti.Haoweilai;

import java.util.Scanner;

/**
 * 数字n被拆分后，可以被3整除的最大数量M
 * <p>
 * 输入：321
 * <p>
 * 输出：2
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();
        int res = getMax(num);
        System.out.println(res);

        scanner.close();

    }

    public static int getMax(String num) {
        int count = 0;
        int sum = 0;
        if (num.length() == 1 && num.charAt(0) == 0) {
            count = 1;
        }
        else if (num.length() > 1) {
            //计算数字之和是否可以被3整除   12345
            for (int i = 0; i < num.length(); i++) {
                int temp = num.charAt(i) - '0';
                sum = sum + temp;
                //对于0的情况也可以被整除
                if (temp == 0) {
                    sum = 0;
                    count++;
                }
                else if (sum % 3 == 0) {
                    count++;
                    sum = 0;
                }
            }
        }
        return count;
    }
}
