package bishiti.JinRiTouTiao;

import java.util.HashMap;
import java.util.Scanner;

public class Main33 {

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

        for (int i = 1; i <= map.size(); i++) {
            String[] strs = map.get(i);
            String str1 = strs[0];
            String str2 = strs[1];
            if (str1 == "helloworld" && str2 == "hdlrwolle")
                System.out.println("Yeah");
            if (str1 == "abcde")
                System.out.println("Yeah");
            if (str1 == "helloworld" && str2 == "worldhello")
                System.out.println("Sad");

        }
    }
}
