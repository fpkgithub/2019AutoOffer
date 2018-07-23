package swordoffer.secondchapter;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class 调整数组顺序使奇数位于偶数前面
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 6, 7, 9, 6};

        //推荐
        int[] res = reOrderArr(arr);
        for (int re : res)
        {
            System.out.print(re + " ");
        }

        System.out.println();

        //冒泡
        int[] res2 = maopao(arr);
        for (int re : res2)
        {
            System.out.print(re + " ");
        }
    }

    private static int[] reOrderArr(int[] arr)
    {
        int oddCount = 0;
        for (int val : arr)
        {
            if (val % 2 == 1)
                oddCount++;
        }
        int i = 0;
        int j = oddCount;
        int[] copy = arr.clone();
        for (int val : copy)
        {
            if (val % 2 == 0)
                arr[j++] = val;
            else
                arr[i++] = val;
        }
        return arr;
    }

    private static int[] maopao(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length - i - 1; j++)
            {
                if (arr[j] % 2 == 0 && arr[j + 1] % 2 == 1)
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
