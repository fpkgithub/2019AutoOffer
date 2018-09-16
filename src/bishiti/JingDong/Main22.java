package bishiti.JingDong;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main22 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solve(String S, String T) {
        int count = 0;
        int len = S.length() - T.length();

        char[] arrT = T.toCharArray();

        for (int i = 0; i < len; i++) {
            String minStr = S.substring(i, i + T.length());
            for (int j = 0; j < T.length(); j++) {
                char a = minStr.charAt(i);
                char b = arrT[j];
                int index = a - 'a';
                if (a == b) {
                    continue;
                }
                minStr = minStr.replaceAll(a + "", arrT[index] + "");

                /*
                String s1 = minStr.substring(j, j + 1);
                String T1 = T.substring(j, j + 1);
                if (s1.equals(T1)) {
                    continue;
                }*/
                //minStr = minStr.replaceAll(s1, T1);
            }
            if (minStr.equals(T)) {
                count++;
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

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }
}
