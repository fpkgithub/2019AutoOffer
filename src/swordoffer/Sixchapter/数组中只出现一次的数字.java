package swordoffer.Sixchapter;

import java.util.ArrayList;

/**
 * 面试题56（一）：数组中只出现一次的两个数字
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 例如：2，4，3，6，3，2，5，5
 * 4，6
 */
public class 数组中只出现一次的数字 {

    public static void main(String[] args) {

        //只有一个数字出现一次
        int[] arr = {3, 9, 6, 4, 6, 3, 5, 5};
        //JustOneShow(arr);
        //int[] arr2 = {3, 4, 6, 9, 6, 3, 5, 5};
        //两个数字出现一次
        //JustTwoShow(arr);

        int num1[] = new int[1];
        int num2[] = new int[1];
        FindNumsAppearOnce(arr, num1, num2);

        /*String a = Integer.toBinaryString(13);
        String b = Integer.toBinaryString(-13);
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        long cc = 13 & (-13);

        System.out.println(cc);*/

    }

    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length == 0)
            return;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!list.contains(array[i]))
                list.add(array[i]);
                //如果存在了 则说明超多了两边 则可以移除
            else
                list.remove(new Integer(array[i]));
        }
        if (list.size() > 1) {
            num1[0] = list.get(0);
            num2[0] = list.get(1);
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }


    private static void JustTwoShow(int[] arr) {

        if (arr == null)
            return;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        int nums[] = new int[2];
        //res &= -res 得到出 res 最右侧不为 0 的位，
        //也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
        res = res & (-res);
        for (int n : arr) {
            if ((n & res) == 0) {
                nums[0] = nums[0] ^ n;
            }
            else {
                nums[1] = nums[1] ^ n;
            }

        }

        System.out.println(nums[0] + " " + nums[1]);

    }

    private static void JustOneShow(int[] arr) {
        if (arr == null)
            return;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        System.out.println(res);
    }
}
