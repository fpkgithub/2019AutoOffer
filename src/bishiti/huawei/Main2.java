package bishiti.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String res = fun(str);
        System.out.println("\n" + res);
        scanner.close();
    }

    public static int[] findLongestNumSubstring(String input)
    {
        // If the string is empty, return [0, 0] directly.
        if (input == null || input.length() == 0)
        {
            return new int[]{0, 0};
        }

        int index = 0;
        int[] ret = new int[]{0, 0}; //[start_index, length]
        int currLen = 0;
        while (index < input.length())
        {
            currLen = 0;
            while (index < input.length() && Character.isDigit(input.charAt(index)))
            {
                currLen++;
                index++;
            }

            // If current substring is longer than or equal to the previously found substring
            // Put it in return values.
            if (currLen != 0 && ret[1] <= currLen)
            {
                ret[1] = currLen;
                ret[0] = index - currLen;
            }
            index++;
        }
        //String res = input.substring(ret[0], ret[0] + ret[1]);
        return ret;
    }

    private static String fun(String str)
    {
        if (str == null || str.length() <= 0)
            return null;

        int maxLen = 0;
        int lens = 1;
        List<String> list = new ArrayList<>();
        for (int i = 1; i < str.length(); i++)
        {
            if (str.charAt(i - 1) == str.charAt(i))
            {
                lens++;
                if (i == str.length() - 1)
                {
                    if (maxLen < lens)
                    {
                        list.add(str.substring(i - lens + 1, i + 1));
                    }
                }
            }
            else
            {
                if (lens == 1)
                    continue;
                if (maxLen < lens)
                {
                    maxLen = lens;
                    list.add(str.substring(i - maxLen, i));
                }
                else if (maxLen == lens)
                {
                    list.add(str.substring(i - lens, i));
                }
                lens = 1;
            }
        }
        for (String s : list)
        {
            System.out.print(s + " ");
        }
        Collections.sort(list);
        System.out.println();
        for (String s : list)
        {
            System.out.print(s + " ");
        }
        return list.get(0);
    }
}
