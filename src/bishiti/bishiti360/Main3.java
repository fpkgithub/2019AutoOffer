package bishiti.bishiti360;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        int res = getMaxLenC(A, B, N);
        System.out.println(res);

        sc.close();


    }

    private static int getMaxLenC(int[] A, int[] B, int N) {

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int temp = A[i];
            boolean flag = false;
            int j = N - 1;
            for (; j >= 0; j--) {
                if (temp == B[j]) {
                    break;
                }
            }

            int count = 0;
            for (int k = j; k >= 0; k--) {

            }
        }

        return 0;
    }
}
