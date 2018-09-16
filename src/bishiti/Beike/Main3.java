package bishiti.Beike;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = gerMinNum(n);
        System.out.println(res);
        scanner.close();
    }

    private static int gerMinNum(int n) {
        if (n == 4)
            return 6;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int res = 0;
        int count = 0;
        int lastNum = 3;
        while (count != n) {
            count = fun(lastNum);
            lastNum++;
        }
        res = lastNum - 1;
        return res;
    }

    private static int fun(int n) {
        int num = n;
        System.out.println(1);
        int count = 2;
        for (int i = 2; i < num; i++) {
            while (num % i == 0) {
                // System.out.println(i);
                num /= i;
                count++;
            }
        }
        if (n > 1) {
            //System.out.println(n);
        }
        return count;
    }
}
