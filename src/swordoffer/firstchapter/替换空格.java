package swordoffer.firstchapter;

/**
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”
 */
public class 替换空格 {

    public static void main(String[] args) {
        String str = "We are happy.";
        String res = replaceSpace(str);
        //StringBuffer str2 = new StringBuffer(str);
        //String res = replaceSpace(str2);
        System.out.println(res);
    }

    //在字符串尾部填充任意字符，使得字符串的长度等于字符串替换之后的长度。因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符。
    //令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2从后向前遍历，当 P1 遍历到一个空格时，
    //就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
    //从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
    //复杂度：O(N) + O(1)
    private static String fun(String str) {
        if (str == null)
            return str;

        // to builder
        StringBuffer str2 = new StringBuffer(str);
        int oldLen = str2.length();
        for (int i = 0; i < oldLen; i++) {
            if (str2.charAt(i) == ' ')
                str2.append("  ");
        }

        int p1 = str.length() - 1;
        int p2 = str2.length() - 1;

        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str2.setCharAt(p2--, '0');
                str2.setCharAt(p2--, '2');
                str2.setCharAt(p2--, '%');
            }
            else {
                str2.setCharAt(p2--, c);
            }
        }
        return str2.toString();
    }

    public static String replaceSpace(String str) {
        char[] oldArr = str.toCharArray();
        int countBlank = 0;
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] == ' ')
                countBlank++;
        }

        char[] newArr = new char[oldArr.length + countBlank * 2];
        int newLen = newArr.length - 1;
        for (int i = oldArr.length - 1; i >= 0 && newLen >= 0; i--) {
            if (oldArr[i] == ' ') {
                newArr[newLen--] = '0';
                newArr[newLen--] = '2';
                newArr[newLen--] = '%';
            }
            else {
                newArr[newLen] = oldArr[i];
                newLen--;
            }
        }


        return new String(newArr);
    }
}
