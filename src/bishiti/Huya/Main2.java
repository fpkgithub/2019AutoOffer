package bishiti.Huya;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        System.out.println(reverseStr(str));

        scanner.close();
    }

    private static String reverseStr(String str) {

        if (str.length() <= 0 || str == null)
            return str;

        char[] chars = str.toCharArray();
        int begin = 0;//记录起始位置
        int last = 0;
        int len = str.length();
        //反正单词
        while (last < len) {
            //last==len是为了处理最后一个字符的  = 也是为了处理最后一个字符
            if (chars[last] == ' ') {
                reverCore(chars, begin, last - 1);
                begin = last + 1;
            }
           /*
            if (last == len - 1) {

            }
            */
            last++;
        }
        //反转最后一个单词
        reverCore(chars, begin, last - 1);
        //反正整个句子
        reverCore(chars, 0, chars.length - 1);
        return new String(chars);


    }

    private static void reverCore(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
