package bishiti.huawei;

import java.util.Scanner;

public class 连续相同字符串
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            String s = scanner.nextLine();
            int j = 0;
            char x = s.charAt(0); // 标志位字符
            char word = s.charAt(0); // 最大长度得字符
            int len = 1;
            int i = 1;
            for (; i < s.length(); i++)
            {
                if (x == s.charAt(i))
                    len++;
                else
                    break;
            }
            int max = len; // 当前最大长度
            len = 1;

            for (; i < s.length(); i++)
            {
                if (x == s.charAt(i))
                {
                    len++;
                }
                else
                {
                    if (len == max)
                    {
                        if (x < word)
                        {
                            max = len; // 当前最大长度
                            word = x;
                        }
                    }
                    else if (len > max)
                    {
                        max = len; // 当前最大长度
                        word = x;
                    }
                    len = 1;
                    x = s.charAt(i); // 更新x
                }
            }
            if (len == max)
            {
                if (x < word)
                {
                    max = len; // 当前最大长度
                    word = x;
                }
            }
            if (len > max)
            {
                max = len; // 当前最大长度
                word = x;
            }

            for (int k = 0; k < max; k++)
            {
                System.out.print(word);
            }
            System.out.println();
        }

        scanner.close();
    }
}
