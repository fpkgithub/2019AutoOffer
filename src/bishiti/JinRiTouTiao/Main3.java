package bishiti.JinRiTouTiao;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();

        HashMap<Integer, String[]> map = new HashMap<>();
        for (int i = 1; i <= testNum; i++) {
            int n = scanner.nextInt();
            String[] strs = new String[n];
            for (int j = 0; j < n; j++) {
                strs[j] = scanner.next();
            }
            map.put(i, strs);
        }
        isShuanShengCi(map);
        scanner.close();

    }

    private static void isShuanShengCi(HashMap<Integer, String[]> map) {

        for (int i = 0; i < map.size(); i++) {
            String[] strs = map.get(i + 1);
            String str1 = strs[0];
            String str2 = strs[1];
            if (str1.length() == str2.length()) {

                char firstStr1 = str1.charAt(0);
                int firstStr2 = str2.indexOf(firstStr1);
                //顺
                boolean flag1 = false;
                int indexStr2 = firstStr2 + 1;
                for (int j = 1; j < str1.length(); j++) {
                    if (indexStr2 == str2.length()) {
                        indexStr2 = 0;
                    }
                    if (str1.charAt(j) != str2.charAt(indexStr2++)) {
                        flag1 = false;
                        break;
                    }
                }
                if (indexStr2 == firstStr2) {
                    flag1 = true;
                }
                //逆
                boolean flag2 = false;
                indexStr2 = firstStr2 - 1;
                for (int j = 1; j < str1.length(); j++) {
                    if (indexStr2 == -1) {
                        indexStr2 = str2.length() - 1;
                    }
                    if (str1.charAt(j) != str2.charAt(indexStr2--)) {
                        flag2 = false;
                        break;
                    }
                }
                if (indexStr2 == firstStr2) {
                    flag2 = true;
                }

                if (flag1 || flag2) {
                    System.out.println("Yeah");
                }else {
                    System.out.println("Sad");
                }
            } else {
                System.out.println("Sad");
            }
        }
    }
}
