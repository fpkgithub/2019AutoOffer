package bishiti.zhihu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int tar = scanner.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int res = getTarIndex(arr, tar);
        System.out.println(res);
        scanner.close();
    }

    private static int getTarIndex(int[] arr, int tar) {

        if (arr.length <= 0 || arr == null)
            return -1;
        int res = getTarIndexCore(arr, 0, arr.length - 1, tar);
        return res;
    }

    private static int getTarIndexCore(int[] arr, int left, int right, int tar) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == tar) {
                int temp = mid;
                while (temp <= right) {
                    if (arr[temp] != tar) {
                        break;
                    }
                    temp++;
                }
                temp--;
                return temp;
            }
            else if (arr[mid] < tar) {
                left = mid;
            }
            else {
                right = mid;
            }
            //处理只有两位数字的问题
            if ((right - mid) == 1) {
                if (arr[right] == tar) {
                    return right;
                }
                else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
