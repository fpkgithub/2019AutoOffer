package bishiti.Aiqiyi;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 小C有一张票，这张票的ID是长度为6的字符串，每个字符都是数字，他想让这个ID变成他的辛运ID，
 * 所以他就开始更改ID，每一次操作，他可以选择任意一个数字并且替换它。
 * 如果这个ID的前三位数字之和等于后三位数字之和，那么这个ID就是辛运的。
 * 你帮小C求一下，最少需要操作几次，能使ID变成辛运ID
 * 输入样例2
 * 000018
 * 输出样例2
 * 1
 * 样例解释：将前三位任意一个改为9即可满足条件，操作数为1
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] preArr = str.substring(0, 3).toCharArray();
        Arrays.sort(preArr);
        char[] postArr = str.substring(3).toCharArray();
        Arrays.sort(postArr);


        int sum1 = getSum(preArr);
        int sum2 = getSum(postArr);

        //000018
        int gap = Math.abs(sum1 - sum2);
        int min = Math.min(sum1, sum2);
        if (gap == 0) {
            System.out.println(0);
        } else if (gap < 10) {
            System.out.println(1);
        } else {
            int times = gap / 9;
            if (gap % 9 != 0) {
                times++;
            } else if (gap % 9 == 0) {
                int temp9 = 0;
                if (min == sum1) {
                    for (int i = 0; i < postArr.length; i++) {
                        if (postArr[i] == '9') {
                            temp9++;
                        }
                    }
                } else {
                    for (int i = 0; i < preArr.length; i++) {
                        if (preArr[i] == '9') {
                            temp9++;
                        }
                    }
                }
                if (temp9 == 2)
                    times++;
            }
            System.out.println(times);
        }
        scanner.close();

    }

    private static int getSum(char[] preArr) {
        int sum = 0;
        for (int i = 0; i < preArr.length; i++) {
            int temp = preArr[i] - '0';
            sum = sum + temp;
        }
        return sum;

    }

}
