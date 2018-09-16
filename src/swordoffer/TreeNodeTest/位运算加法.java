package swordoffer.TreeNodeTest;

public class 位运算加法 {
    public static void main(String[] args) {

        int a = 3;
        int b = 9;
        System.out.println(sumByByte(a, b));


    }

    //递归写法

    /**
     * 由a^b可得按位相加后没有进位的和；
     * 由a&b可得可以产生进位的地方；
     * 由(a&b)<<1得到进位后的值。
     * 那么  按位相加后原位和+进位和  就是加法的和了，
     * 而  a^b +  (a&b)<<1  相当于把  +  两边再代入上述三步进行加法计算。
     * 直到进位和为0说明没有进位了则此时原位和即所求和。
     */
    private static int sumByByte(int a, int b) {

        if (b == 0)
            return a;
        //由a^b可得按位相加后没有进位的和   ^异或操作
        int sum = a ^ b;  //0011 ^ 1001 = 1010
        int carry = (a & b) << 1;  //0001  0010  << 左移运算符，num << 1,相当于num乘以2
        return sumByByte(sum, carry);

    }


    //迭代运算  https://www.jianshu.com/p/7bba031b11e7

    /**
     * 第一步不考虑进位的加法其实就是异或运算
     * 第二部只考虑进位就是与运算并左移一位--
     * 第三步就是重复前面两步操作直到第二步进位结果为0。
     */
    private static int sumByByte2(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int num1 = sum;
            int num2 = carry;
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
        }
        return sum;
    }


}
