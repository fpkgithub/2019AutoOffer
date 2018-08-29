package bishiti.zhihu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int A[] = new int[num1];
        int B[] = new int[num2];

        for (int i = 0; i < num1; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < num2; i++) {
            B[i] = scanner.nextInt();
        }

        int[] C = merger(A, B);
        for (int val : C) {
            System.out.print(val + " ");
        }

        scanner.close();
    }

    private static int[] merger(int[] A, int[] B) {
        int lenA = A.length;
        int i = 0;
        int lenB = B.length;
        int j = 0;
        int[] C = new int[lenA + lenB];
        int k = 0;
        while (i < lenA && j < lenB) {
            if (A[i] <= B[j]) {
                C[k++] = A[i++];
            }
            else {
                C[k++] = B[j++];
            }
        }

        if (i < lenA) {
            while (i < lenA) {
                C[k++] = A[i++];
            }
        }
        if (j < lenB) {
            while (j < lenB) {
                C[k++] = B[j++];
            }
        }

        return C;
    }

}
