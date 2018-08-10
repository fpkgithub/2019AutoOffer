package swordoffer.sort;

/**
 * 思想：
 * 归并排序是建立在归并操作上的一种有效的排序算法。
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 归并排序是一种稳定的排序方法。
 * 将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 7, 5, 6, 2, 2, 3, 4, 5, 6, 0, 6, -1};
        printArr(arr);

        guibinSort(arr, 0, arr.length - 1);

        printArr(arr);
    }

    private static void guibinSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        guibinSort(arr, left, mid);
        guibinSort(arr, mid + 1, right);
        merger(arr, left, mid, right);
    }

    private static void merger(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int n = 0; n < temp.length; n++) {
            arr[left + n] = temp[n];
        }

    }

    private static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
