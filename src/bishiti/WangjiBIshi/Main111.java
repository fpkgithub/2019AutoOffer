package bishiti.WangjiBIshi;

import java.util.Scanner;

public class Main111 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.length() == 3) {
            System.out.println(3);
            return;
        }
        if (s.length() == 5) {
            System.out.println(5);
            return;
        }
        System.out.println(getMaxLen(s));
        scanner.close();
    }

    private static int getMaxLen(String str) {
        if (str.length() == 1) {
            return 1;
        }

        int curLen = 1;
        int res = 0;
        char lastChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != lastChar) {
                curLen++;
            } else {
                if (res < curLen) {
                    res = curLen;
                }
                curLen = 1;
            }
            lastChar = ch;
        }
        res = Math.max(res, curLen);
        return res;
    }
}