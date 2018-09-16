package bishiti.JingDong;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    //最长公共子序列连续
    private static int getLongestCommonSequence3(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0 || lenA < lenB) {
            return 0;
        }

        int count = 0;

        int begin = 0;
        int end = lenB;
        while (end < lenA) {
            //滑动窗口取值
            char[] subA = a.substring(begin, end).toCharArray();

            String temp = "";
            for (int i = 0; i < subA.length; i++) {
                char C = subA[i];
                int index = C - 'a';
                subA[i] = b.charAt(index);
            }
        }
        return count;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }

        res = getLongestCommonSequence3(_S, _T);
        System.out.println(String.valueOf(res));

    }
}
