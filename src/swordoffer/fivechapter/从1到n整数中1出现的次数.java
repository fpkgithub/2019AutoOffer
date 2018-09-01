package swordoffer.fivechapter;

public class 从1到n整数中1出现的次数 {

    public static void main(String[] args) {

        int num = 123;
        int res = getNumberOf1(num);
        System.out.println(res);
        int res2 = getNumberOf12(num);
        System.out.println(res2);

    }

    //思想：动态规划问题
    //f(i) : 第i个数字结尾的子数组的最大和，那么我们需要求出max[f(i)]，其中0<=i<=n
    //f(i) = pData[i] i=0/f(i-1)<=0
    //f(i) = f(i-1) + pData[i] i!=0并且f(i-1) > 0
    private static int getNumberOf12(int num) {

        return 0;
    }

    private static int getNumberOf1(int num) {

        int res = 0;
        for (int i = 0; i < num; i++) {
            res = res + get1FromNumber(i);
        }
        return res;
    }

    private static int get1FromNumber(int i) {
        int res = 0;
        while (i > 0) {
            if (i % 10 == 1)
                res++;
            i = i / 10;
        }
        return res;
    }
}
