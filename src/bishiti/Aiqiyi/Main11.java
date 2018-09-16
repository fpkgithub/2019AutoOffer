package bishiti.Aiqiyi;


import java.util.Scanner;
import java.util.concurrent.locks.Lock;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int a = chars[0] + chars[1] + chars[2] - 144;
        int b = chars[3] + chars[4] + chars[5] - 144;
        int min1 = chars[0];
        int min2 = chars[3];
        for (int i = 0; i < chars.length; i++) {
            if (i >= 1 && i <= 2) {
                min1 = Math.min(min1, chars[i]);
            }
            if (i >= 4 && i <= 5) {
                min2 = Math.min(min2, chars[i]);
            }
        }
        int min = a < b ? min1 - 48 : min2 - 48;
        if (a == b) {
            System.out.println(0);
        } else if (Math.abs(a - b) >= 19) {
            System.out.println(3);
        } else if (Math.abs(a - b) <= 9 - min) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}