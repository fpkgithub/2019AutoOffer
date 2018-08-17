package bishiti.wangyi;

import java.util.Scanner;

/**
 * 5
 * 2 7 3 4 9
 * 3
 * 1 25 11
 */
public class guoyuan {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int q[] = new int[m];
        for (int i = 0; i < q.length; i++) {
            q[i] = scanner.nextInt();
        }

        int[] res = new int[count];
        res[0] = arr[0];
        // 累加
        for (int i = 1; i < count; i++) {
            res[i] = arr[i] + res[i - 1];
        }
        // 二分查找
        for (int i = 0; i < m; i++) {
            int j = 0, k = count - 1;
            while (j < k) {
                int mid = (j + k) / 2;
                if (q[i] > res[mid])
                    j = mid + 1;
                else if (q[i] < res[mid])
                    k = mid;
                else
                    k = mid;
            }
            System.out.println(k + 1);

        }
    }

}
