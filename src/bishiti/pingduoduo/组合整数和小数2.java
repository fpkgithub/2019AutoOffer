package bishiti.pingduoduo;

import java.util.Scanner;

/**
 * 123
 */
public class 组合整数和小数2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = allgroups(n + "");
        System.out.println(res);

        scanner.close();
    }

    private static int allgroups(String str) {

        int len = str.length();
        if (len == 0)
            return 0;
        if (len == 1)
            return 1;
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            //组合问题相乘
            sum = sum + groups(str, 0, i) * groups(str, i + 1, len - 1);
        }
        return sum;

    }

    private static int groups(String str, int start, int end) {

        //记录有几个组合
        int count = 0;
        //只有一个字符
        if (end == start) {
            count++;
        }
        else {
            //第一个字符是0
            if (str.indexOf(start) == '0') {
                //最后一个字符不为零
                if (str.indexOf(end) != '0') {
                    count++;
                }
                else {
                    //最后一个字符为零则无法有组合
                    return 0;
                }
            }
            else {
                if (str.indexOf(end) == '0') {
                    count++;
                }
                else {
                    //只考虑小数点的位置
                    count = end - start + 1;
                }
            }
        }
        return count;
    }

}
