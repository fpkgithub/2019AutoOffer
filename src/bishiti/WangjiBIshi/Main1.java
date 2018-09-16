package bishiti.WangjiBIshi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = getMaxLen(s);
        System.out.println(res);
        sc.close();
    }

    //bwbwb
    private static int getMaxLen(String s) {
        int res = 0;
        int len = s.length();
        int wlen = 0;
        int blen = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'b') {
                wlen++;
            } else if (s.charAt(i) == 'w') {
                blen++;
            }
        }
        int count = Math.abs(wlen - blen);
        res = wlen > blen ? blen : wlen;
        if (count <= 1) {
            return wlen + blen;
        } else {
            return res + res + 1;
        }
    }
}
