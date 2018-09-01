package swordoffer.fivechapter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 45：题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 */
public class 把数组排成最小的数 {

    public static void main(String[] args) {

        int[] numbers = {3, 32, 321};
        String res = PrintMinNumber(numbers);
        PrintMinNumber2(numbers);

        System.out.println(res);
    }

    private static String PrintMinNumber2(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";

        int len = numbers.length;

        //自定义一个比较大小的函数，比较两个字符串s1, s2大小的时候，先将它们拼接起来，
        // 比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        String res = "";
        for (int i = 0; i < len; i++) {
            res += numbers[i];
        }
        return res;
    }

    /**
     * 思路
     * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
     * 若ab > ba 则 a > b，
     * 若ab < ba 则 a < b，
     * 若ab = ba 则 a = b；
     * 解释说明：
     * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
     */
    public static String PrintMinNumber(int[] numbers) {
        String res = "";
        if (numbers == null || numbers.length == 0)
            return res;
        int len = numbers.length;

        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }
}
