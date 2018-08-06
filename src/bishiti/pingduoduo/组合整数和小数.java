package bishiti.pingduoduo;

import java.util.Scanner;

/**
 * 123
 */
public class 组合整数和小数 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int res = getNum(n + "");
        System.out.println(res);

        scanner.close();
    }

    private static int getNum(String str) {

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += find(str, i);
        }
        return sum;
    }

    private static int find(String str, int cut) {
        int left = 0;
        if (str.indexOf(0) != '0')
            left++;
        else if (cut == 1)
            left++;

        left += find2(str, 0, cut - 1);

        if (left == 0)
            return 0;

        int right = 0;
        if (str.indexOf(cut) != '0')
            right++;
        else if (cut == str.length() - 1)
            right++;
        right += find2(str, cut, str.length() - 1);

        return left * right;
    }

    private static int find2(String str, int left, int right) {

        if (left == right || str.indexOf(right) == '0')
            return 0;
        if (str.indexOf(left) == '0')
            return 1;
        return right - left;
    }
}
