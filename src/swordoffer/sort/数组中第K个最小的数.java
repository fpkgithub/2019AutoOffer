package swordoffer.sort;

public class 数组中第K个最小的数 {
    public static void main(String[] args) {

        int[] arr = {3, 1, 4, 7, 5, 6, 2};

        int k = 1;
        printArr(arr);

        //第1大的数字，则len-1  第k大的数字，则len - k
        //第k小的数字，则k-1
        int res = quickSort2(arr, 0, arr.length - 1, arr.length - k);

        printArr(arr);
        System.out.println(res);
    }

    private static int quickSort2(int[] arr, int left, int right, int k) {

        if (left >= right)
            return arr[left];
        int index = getIndex(arr, left, right);
        if (index == k) {
            return arr[index];
        }
        else if (index > k) {
            return quickSort2(arr, left, index - 1, k);
        }
        else {
            return quickSort2(arr, index + 1, right, k);
        }
    }

    public static int getIndex(int[] arr, int left, int right) {
        System.out.println("***");
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i < j) {
            while (i < j && arr[j] > temp) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] < temp) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = temp;
        return i;
    }

    private static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }


}
