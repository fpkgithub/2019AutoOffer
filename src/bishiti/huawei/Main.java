package bishiti.huawei;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        List<Character> res = getRepeatStr(str);
        for (Character re : res)
        {
            System.out.print(re);
        }
        scanner.close();
    }

    private static List<Character> getRepeatStr(String str)
    {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char curChar = str.charAt(i);
            if (map.get(curChar) == null)
            {
                map.put(curChar, 1);
            }
            else
            {
                map.put(curChar, map.get(curChar) + 1);
            }
            if (map.get(curChar) == 1)
            {
                list.add(curChar);
            }
        }
        Collections.sort(list);
        return list;
    }

    private static Set getRepeatStr2(String str)
    {
        Set<Character> list = new TreeSet();
        for (int i = 0; i < str.length(); i++)
        {
            char cur = str.charAt(i);
            String s2 = str.substring(i + 1, str.length());
            if (s2.contains(cur + ""))
            {
                list.add(cur);
            }
        }
        return list;
    }

}
