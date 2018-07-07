package swordoffertest;

public class 数组中重复的数字
{

    public static void main(String[] args)
    {
        int[] nums = {2, 3, 1 , 0, 5};
        //int[] dup = new int[nums.length];
        boolean res = fun(nums, nums.length);
        System.out.println(res);
    }

    //231005
    //132005
    //102305
    private static boolean fun(int[] nums, int length)
    {
        if (nums == null || nums.length <= 0)
            return false;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0 || nums[i] > length - 1)
                return false;
        }

        for (int i = 0; i < nums.length; i++)
        {
            while (nums[i] != i)//1:当前值是否符合下标
            {
                if (nums[i] == nums[nums[i]])//2：当前下标值等于下标值的下标值
                {
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
