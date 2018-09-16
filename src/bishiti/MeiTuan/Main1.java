package bishiti.MeiTuan;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] arr = new int[N - 1][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        int res = fun(arr);

        System.out.println(res);

        scanner.close();

    }

    private static int fun(int[][] arr) {
        int res = 0;


        return res;
    }
}
