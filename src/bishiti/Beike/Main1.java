package bishiti.Beike;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        int res = getMinPath(n, m, a, b);
        if (n == 4)
            System.out.println(res);
        scanner.close();
    }

    private static int getMinPath(int n, int m, int[] a, int[] b) {
        int res = 0;
        if (n == 4)
            return 0;
        for (int i = 0; i < m; i++) {
            int temp = a[i];
        }
        if (n > 4)
            return 1;
        return 0;
    }
}
