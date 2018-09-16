package bishiti.WeiPinHui;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85177/Java-1ms-nlog(max-min)-solution
 * 输入：
 * 8 3
 * 1 5 9
 * 10 11 13
 * 12 13 15
 * 输出：
 * 13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arrMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrMatrix[i][j] = scanner.nextInt();
            }
        }
        int res = getKthNum(arrMatrix, k);
        System.out.println(res);
        scanner.close();
    }

    //二分查找
    public static int getKthNum(int[][] arrMatrix, int k) {
        int n = arrMatrix.length;
        int low = arrMatrix[0][0];
        int high = arrMatrix[n - 1][n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getLessEqual(arrMatrix, mid);

            if (count < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    //
    private static int getLessEqual(int[][] arrMatrix, int val) {
        int res = 0;
        int n = arrMatrix.length, i = n - 1, j = 0;

        while (i >= 0 && j < n) {
            if (arrMatrix[i][j] > val) {
                i--;
            }
            else {
                res += i + 1;
                j++;
            }
        }
        return res;
    }
}
