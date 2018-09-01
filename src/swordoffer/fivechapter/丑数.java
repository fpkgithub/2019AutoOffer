package swordoffer.fivechapter;

/**
 * 49：把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。
 * 求按从小到大的顺序的第 N 个丑数。
 */
public class 丑数 {
    public static void main(String[] args) {
        int num = 3;
        //int res = getUglyNUm(num);
        //System.out.println(res);

        int res2 = getUglyNUm2(num);
        System.out.println(res2);
    }

    private static int getUglyNUm2(int num) {
        if (num <= 0)
            return 0;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        //存放丑数
        int[] uglyArr = new int[num];
        uglyArr[0] = 1;//初始化1
        for (int i = 1; i < num; i++) {
            //按顺序将丑数保存再数组中，因为要按照 2 3 5，每次相乘后要选最小的加入数组并移动下表位置
            int next2 = uglyArr[i2] * 2;
            int next3 = uglyArr[i3] * 3;
            int next5 = uglyArr[i5] * 5;
            //uglyArr[i] = Math.min(next2, Math.min(next3, next5));
            uglyArr[i] = getMinNum(next2, next3, next5);
            //更新丑数
            if (uglyArr[i] == next2)
                i2++;
            if (uglyArr[i] == next3)
                i3++;
            if (uglyArr[i] == next5)
                i5++;
        }
        return uglyArr[num - 1];
    }

    private static int getMinNum(int next2, int next3, int next5) {
        int min = next2 < next3 ? next2 : next3;
        return min < next5 ? min : next5;
    }

    private static int getUglyNUm(int num) {

        if (num <= 0)
            return 0;

        int number = 0;
        int index = 0;
        while (index < num) {
            number++;
            if (isUhlyNum(number)) {
                index++;
            }
        }
        return number;


    }

    private static boolean isUhlyNum(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }

        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return (number == 1) ? true : false;
    }
}
