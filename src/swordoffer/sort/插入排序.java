package swordoffer.sort;

import static swordoffer.sort.选择排序.swap;

/**
 * 对于基准位置的选取一般有三种方法：固定切分，随机切分和三取样切分。
 * 固定切分的效率并不是太好，
 * 随机切分是常用的一种切分，效率比较高，最坏情况下时间复杂度有可能为O(N2).
 * 对于三数取中选择基准点是最理想的一种。
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 7, 5, 6, 2};

        printArr(arr);
        charuSort(arr);

        //快排
        quickSor(arr, 0, arr.length - 1);

        printArr(arr);
    }

    private static void quickSor(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int index = quickSorCore2(arr, left, right);
        quickSor(arr, left, index - 1);
        quickSor(arr, index + 1, right);

    }

    private static int quickSorCore2(int[] arr, int left, int right) {
        //在此我们采用三数取中法，也就是取左端、中间、右端三个数，然后进行排序，将中间数作为枢纽值。
        int mid = left + (right - left) / 2;
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[mid] > arr[right]) {
            swap(arr, mid, right);
        }

        int baseKey = arr[mid];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] > baseKey) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < baseKey) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }

        arr[i] = baseKey;
        return i;
    }

    private static int quickSorCore1(int[] arr, int left, int right) {

        int i = left;
        int j = right;
        int target = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= target) {
                j--;
            }
            if (i < j)
                arr[i++] = arr[j];
            while (i < j && arr[i] <= target) {
                i++;
            }
            if (i < j)
                arr[j--] = arr[i];
        }
        arr[i] = target;
        return i;
    }

    private static void charuSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = 0;
            for (j = i; j > 0; j--) {
                if (temp < arr[j - 1])
                    arr[j] = arr[j - 1];
                else
                    break;
            }
            arr[j] = temp;
        }
    }

    private static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
