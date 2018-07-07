package swordoffer.firstchapter;

/**
 * 面试题3（一）：找出数组中重复的数字
 * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 */
public class 数组中重复的数字
{
    public static void main(String[] args)
    {
        int[] nums = {2, 3, 1, 0, 0, 5};
        int[] dup = new int[nums.length];
        boolean res = fun(nums, nums.length, dup);
        System.out.println(res);
    }

    //解题思路：[0 - n-1] 根据下标来进行判断
    //2310235
    //1320235
    //3120235
    //0123235
    //2
    public static boolean fun(int nums[], int length, int duplication[])
    {
        if (nums == null || nums.length <= 0)
            return false;

        //在一个长度为n的数组里的所有数字都在0到n-1的范围内
        for (int i = 0; i < length; i++)
        {
            if (nums[i] < 0 || nums[i] > length - 1)
                return false;
        }

        for (int i = 0; i < nums.length; i++)
        {
            while (nums[i] != i)
            {
                if (nums[i] == nums[nums[i]])
                {
                    duplication[0] = nums[i];
                    System.out.println(duplication[0]);
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
