package swordoffertest;

/**
 * 题目：
 * 在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
 *
 * 思路：
 * 特殊条件，数组的范围是1-n的，长度为n+1
 * 因此构造一个数组，初始化为-1，然后遍历数组
 *
 */
public class 不修改数组找出重复的数字
{

    public static void main(String[] args) {

        不修改数组找出重复的数字 res = new 不修改数组找出重复的数字();
        res.findDuplicateNum(new int[]{2, 3, 5, 4, 3, 2, 6, 7, 4});
    }


    private void findDuplicateNum(int[] arry){

        int[] flagArras = new int[arry.length];
        for (int i = 0; i < flagArras.length; i++) {
            flagArras[i] = -1;
        }

        for (int i = 0; i < arry.length; i++) {

            if (flagArras[arry[i]] == 1){
                System.out.println(arry[i]);
            }

            if (flagArras[arry[i]] == -1){
                flagArras[arry[i]] = 1;
            }
        }
        return;
    }

}
