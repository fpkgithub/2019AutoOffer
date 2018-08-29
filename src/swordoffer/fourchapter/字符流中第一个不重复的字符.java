package swordoffer.fourchapter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 * 当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 */
public class 字符流中第一个不重复的字符 {

    public static void main(String[] args) {
        String str = "google";
        //System.out.println(FirstNotRepeatingChar(str));
        System.out.println(FirstNotRepeatingChar2(str));
    }

    private static int FirstNotRepeatingChar2(String str) {

        char[] arr = str.toCharArray();
        int[] arrCount = new int['z'];

        for (char c : arr) {
            arrCount[c]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arrCount[arr[i]] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int FirstNotRepeatingChar(String str) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c) + 1;
                map.put(c, count);
            }
            else {
                map.put(c, 1);
            }
        }
        int res = -1;
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
