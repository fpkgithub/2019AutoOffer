package swordoffer.leetcode;


/**
 * 一趟排序确定一个元素：
 * 通过一躺排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一不部分的所有数据都要小，
 * 然后再按次方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 1：冒泡排序 稳定   O(n2)  ->  O(n2)
 * 2：快速排序 不稳定 O(nlgn) -> O(n2)
 * 参考：https://www.jianshu.com/p/4db794bd7c1b
 */
public class 交换排序 {

    private void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int index = getBaseIndex(arr,left,right);
        quickSort(arr,left,index-1);
        quickSort(arr, index+1, right);
    }

    //每一个排序确定一个元素并返回这个元素的index
    private int getBaseIndex(int[] arr, int left, int right){
        int base = arr[left];
        while (left < right){
            while ( left < right && base < arr[right]){//base都小于right
               right--;
            }
            if( left < right )
                arr[left++] = arr[right];
            while ( left < right && base > arr[left]){//base大于left
                left++;
            }
            if (left < right)
                arr[right--] = arr[left];
        }
        arr[left] = base;
        print(arr);
        return left;
    }

    /**
     * 常规的冒泡排序
     * @param arr
     */
    private void maopaoSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length -i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        print(arr);
    }

    /**
     * 外层循环的i表示数组前面已经有序的个数
     * 排序时候从后边开始，将较小者往前边移动
     * 如果前面已经有序了则直接退出
     * @param arr
     */

    private void maopaoSort2(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = arr.length -1; j > i; j--) {
                if( arr[j-1] > arr[j] ){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }

        print(arr);
    }

    private void print(int arr[]){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        交换排序 res = new 交换排序();
        int[] arr = {4,1,6,5,2,3,10};
        //res.maopaoSort(arr);
        //res.maopaoSort2(arr);
        res.print(arr);
        res.quickSort(arr,0, arr.length-1);
        res.print(arr);
    }
}
