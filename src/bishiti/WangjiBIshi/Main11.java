package bishiti.WangjiBIshi;

import java.util.Scanner;

public class Main11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = getMaxLen(s);
        System.out.println(res);
        sc.close();

    }

    private static int getMaxLen(String s) {
        int count = 1;
        int res = 1;
        int len = s.length();

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                res = res + 1;
            } else {
                count = Math.max(count, res);
                res = 1;
            }
        }

        return count;
    }
}
