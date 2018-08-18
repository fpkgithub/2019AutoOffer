package swordoffer.Sixchapter;

public class 数组中只出现一次的数字 {

    public static void main(String[] args) {

        //只有一个数字出现一次
        int[] arr = {3, 9, 6, 4, 6, 3, 5, 5};
        //JustOneShow(arr);
        //int[] arr2 = {3, 4, 6, 9, 6, 3, 5, 5};
        //两个数字出现一次
        JustTwoShow(arr);
        /*String a = Integer.toBinaryString(13);
        String b = Integer.toBinaryString(-13);
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        long cc = 13 & (-13);

        System.out.println(cc);*/

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
