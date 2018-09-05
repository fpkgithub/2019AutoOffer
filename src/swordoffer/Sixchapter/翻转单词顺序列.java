package swordoffer.Sixchapter;

/**
 * 面试题58（一）：翻转单词顺序
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 */
public class 翻转单词顺序列 {

    public static void main(String[] args) {
        String str = "I am a student.";
        //String str = "student. a am I";
        System.out.println(reverseStr(str));
    }

    private static String reverseStr(String str) {

        if (str.length() <= 0 || str == null)
            return str;

        //String[] s = str.split("\\s+");

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
