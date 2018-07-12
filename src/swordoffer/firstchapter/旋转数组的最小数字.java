package swordoffer.firstchapter;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组 {3, 4, 5, 1, 2} 为 {1, 2, 3, 4, 5} 的一个旋转，
 * 该数组的最小值为 1。
 * NOTE：给出的所有元素都大于 0，若数组大小为 0，请返回 0。
 */
public class 旋转数组的最小数字
{
    public static void main(String[] args)
    {
        int[] a = {3, 4, 5, 1, 2, 3};
        int res = getMinNum(a);
        System.out.println(res);
    }


    //3, 4, 5, 1, 2
    //a[m] <= a[j]  在 i  m找
    //a[m] > a[j]   在 m  j找
    private static int getMinNum(int[] a)
    {
        if (a.length <= 0)
            return 0;
        int i = 0;
        int j = a.length - 1;
        while (i < j)
        {

            int mid = (i + j) / 2;
            if (a[mid] <= a[j])
            {
                j = mid;
            }
            else
            {
                i = mid + 1;
            }
        }
        return a[i];
    }
}
