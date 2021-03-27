package swordoffer.sort;

public class 交换排序 {
    public static void main(String[] args) {

        //int[] arr = {3, 1, 4, 7, 5, 6, 2};

        int[] arr = {4,1,6,5,2,3,10};
        printArr(arr);
        // 基于交换排序
        //System.out.println("\n基于交换排序");
        //maopaoSort(arr);
        //maopaoSort2(arr);
        //maopaoSort3(arr);

        System.out.println("快排");
        /**
         * 对于基准位置的选取一般有三种方法：固定切分，随机切分和三取样切分。
         * 固定切分的效率并不是太好，随机切分是常用的一种切分，效率比较高，最坏情况下时间复杂度有可能为O(N2).
         * 对于三数取中选择基准点是最理想的一种。
         */
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);

        //quickSort2(arr, 0, arr.length - 1);
        //printArr(arr);

    }

    private static void quickSort2(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int index = getIndex2(arr, left, right);
        quickSort2(arr, left, index - 1);
        quickSort2(arr, index + 1, right);
    }

    //三数取中切分：
    private static int getIndex2(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] > arr[right])
            swap(arr, mid, right);
        if (arr[left] > arr[mid])
            swap(arr, left, mid);
        if (arr[left] > arr[right])
            swap(arr, left, right);
        int baseNum = arr[mid];
        while (left < right) {
            while (left < right && arr[right] > baseNum) {
                right--;
            }
            while (left < right && arr[left] < baseNum) {
                left++;
            }
            swap(arr, right, left);
        }
        arr[left] = baseNum;
        return left;
    }

    private static int getIndex(int[] arr, int left, int right) {
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] > base) {
                right--;
            }
            while (left < right && arr[left] < base) {
                left++;
            }
            swap(arr, left, right);
        }
        arr[left] = base;
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = getBaseIndex(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    private static int getBaseIndex(int[] arr, int left, int right) {
        int base = arr[left];
        while (left < right) {
            while ( left < right && arr[right] > base) {
                right--;
            }
            if (left < right)
                arr[left++] = arr[right];
            while ( left < right && arr[left] < base) {
                left++;
            }
            if (left < right)
                arr[right--] = arr[left];
        }
        arr[left] = base;
        System.out.print(left + ":");
        return left;
    }


    private static void maopaoSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        printArr(arr);
    }

    private static void maopaoSort2(int[] arr) {
        //外层循环的i表示数组前面已经有序的个数
        for (int i = 0; i < arr.length; i++) {
            //排序时候从后边开始，将较小者往前边移动。这样较小者会不断往前移动
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;

                }
            }
        }
        printArr(arr);
    }

    private static void maopaoSort3(int[] arr) {
        boolean flag = true;
        //外层循环的i表示数组前面已经有序的个数
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    //若本次有交换发生，则将flag重置为true
                    flag = true;

                }
            }
            //当一趟本来就是有序，未发生交换，则直接跳出
            if (!flag) {
                break;
            }
        }
        printArr(arr);
    }


    private static void printArr(int[] arr) {
        System.out.println();
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
