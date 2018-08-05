package swordoffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 常见输入格式 {
    public static void main(String[] args) {
        /**
         * 输入：
         * 5
         * 1,2,3,4,5
         */
        //普通输入();


        /**
         * 注意要使用Scanner.nextLine()
         * 输入：
         * 1 2  3            4 5
         */

        //空格划分();

        /**
         * 输入二维数组：
         * 3 3
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
        //二维数组();


        //while.hasnext()输入
        Input();


    }

    private static void Input() {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            String str = scanner.next();
            int num = scanner.nextInt();
            map.put(str, num);
        }

        for (String s : map.keySet()) {
            System.out.println(s);
        }


        scanner.close();


    }

    private static void 二维数组() {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("打印：");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void 空格划分() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //String[] strArr = str.split(" ");
        String[] strArr = str.split("\\s+");
        System.out.println("strArr len:" + strArr.length);
        for (String s : strArr) {
            System.out.print(s + "-");
        }
        scanner.close();
    }

    private static void 普通输入() {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();

        String str1 = scanner.next();
        System.out.println(str1);

        char[] a1 = str1.toCharArray();
        System.out.println("a1 len:" + a1.length);
        for (char c : a1) {
            System.out.print(c + " ");
        }

        scanner.close();
    }
}
