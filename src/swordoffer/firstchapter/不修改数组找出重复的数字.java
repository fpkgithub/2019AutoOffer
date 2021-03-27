package swordoffer.firstchapter;

/**
 * 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 * 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 * 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 * 输出是重复的数字2或者3。
 */
public class 不修改数组找出重复的数字
{

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 4, 5, 6, 3, 1,3};
        int res = fun(arr);
        System.out.println(res);
    }


    private static int fun(int[] arr)
    {
        if (arr == null || arr.length <= 0)
            return -1;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < 0 || arr[i] > arr.length - 1)
            {
                return -1;
            }
        }

        int temp = -1;

        int[] arr_temp = new int[arr.length];
        for (int i = 0; i < arr_temp.length; i++)
        {
            arr_temp[i] = -1;
        }
        for (int i = 0; i < arr.length; i++)
        {
            if (arr_temp[arr[i]] != -1)
            {
                temp = arr[i];
                return temp;
            }
            arr_temp[arr[i]] = arr[i];
        }
        return temp;
    }
}
