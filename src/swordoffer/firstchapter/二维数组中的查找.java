package swordoffer.firstchapter;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 */
public class 二维数组中的查找
{
    public static void main(String[] args)
    {

        int[][] arr = { {1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        int target = 12;
        boolean res = find(arr, target);
        System.out.println(res);
    }

    //从右上角开始查找。因为矩阵中的一个数，它左边的数都比它小，下边的数都比它大。
    //因此，从右上角开始查找，就可以根据 target 和当前元素的大小关系来缩小查找区间。
    private static boolean find(int[][] arr, int target)
    {
        if(arr == null || arr.length <= 0 || arr[0].length <= 0)
            return false;

        //核心
        int rows = arr.length;
        int columns = arr[0].length;

        int r = 0;
        int c = columns-1;
        while(r< rows && c < columns)
        {
            if(target == arr[r][c])
                return true;
            else if(target < arr[r][c])
                c--;
            else
                r++;
        }

        return false;
    }
}
