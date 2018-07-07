package swordoffertest;

public class 替换空格
{
    public static void main(String[] args)
    {
        String str = "We are happy.";
        StringBuffer str2 = new StringBuffer(str);
        String res = fun(str2);
        //String res = replaceSpace(str2);
        System.out.println(res);
    }

    private static String fun(StringBuffer str)
    {

        int oldLen = str.length();
        for (int i = 0; i < oldLen; i++)
        {
            if (str.charAt(i) == ' ')
                str.append("  ");
        }

        int p1 = oldLen - 1;
        int p2 = str.length() - 1;

        while (p1 >= 0 && p2 > p1)
        {
            char c = str.charAt(p1--);
            if (c == ' ')
            {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }
            else
            {
                str.setCharAt(p2--, c);
            }

        }
        return str.toString();
    }
}
