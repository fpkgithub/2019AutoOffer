package bishiti.JingDong;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arrs = new int[M][2];
        for (int i = 0; i < M; i++) {
            arrs[i][0] = scanner.nextInt();
            arrs[i][1] = scanner.nextInt();
        }

        boolean res = fun(N, M, arrs);
        if (res) {
            System.out.println("Yes");
        }

        scanner.close();
    }

    private static boolean fun(int n, int m, int[][] arrs) {

        return true;
    }
}
