package bishiti.Huya;

import java.util.Scanner;

public class Main11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        while (true) {
            String str = scanner.nextLine().replaceAll("\\s*", "");
            sb.append(str).append(" ");
            if (str.length() >= 18) break;
        }
        String s = sb.toString().substring(0, sb.length());
        fun(s);
        scanner.close();
    }

    public static void fun(String s) {
        String[] str1 = s.split(" ");
        for (int i = 0; i < str1.length; i++) {
            int n = str1[i].length();
            if (n <= 6) {
                System.out.println(str1[i]);
            } else if (n <= 14) {
                String temp = str1[i].substring(0, 6) + " " + str1[i].substring(6, n);
                System.out.println(temp);
            } else {
                String temp = str1[i].substring(0, 6) + " " + str1[i].substring(6, 14) + " " + str1[i].substring(14, n);
                System.out.println(temp);
            }
        }
    }


}