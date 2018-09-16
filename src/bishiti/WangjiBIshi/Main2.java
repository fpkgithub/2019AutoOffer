package bishiti.WangjiBIshi;

import java.util.Scanner;

/**
 * 6
 * 1 0
 * 1 1
 * 2 0
 * 2 1
 * 2 2
 * 6 4
 * <p>
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 0 0
 * 0 2
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrN = new int[n];
        int[] arrK = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
            arrK[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            buyHouse(arrN[i], arrK[i]);
        }
        sc.close();
    }

    public static void buyHouse(int n, int k) {
        if (n == 0 || k == 0 || n - k == 0) {
            System.out.println(0 + " " + 0);
            return;
        }
        System.out.print(0 + " ");
        if (k > n - k) {
            System.out.println(n - k);
        } else {
            System.out.println(k - 1);
        }
    }

}