package swordoffer.secondchapter;

/**
 * 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，而 '*'
 * 表示它前面的字符可以出现任意次（包含 0 次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串 "aaa" 与模式 "a.a" 和 "ab*ac*a" 匹配，但是与 "aa.a" 和 "ab*a" 均不匹配。
 */
public class 正则表达式匹配
{
    public static void main(String[] args)
    {
        /**
         * 这道题的核心其实在于分析'*',对于'.'来说，它和任意字符都匹配，可把其当做普通字符。
         * 对于'*'的分析，我们要进行分情况讨论，当所有的情况都搞清楚了以后，就可以写代码了。
         *
         当模式中的第二个字符不是“*”时：
         1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
         2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

         而当模式中的第二个字符是“*”时：
         如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
         1、模式后移2字符，相当于x*被忽略；
         2、字符串后移1字符，模式后移2字符；
         3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
         *
         */

        String str = "aaa";
        String pattern = "*ab";
        boolean res = math(str.toCharArray(), pattern.toCharArray());
        System.out.println(res);
    }

    private static boolean math(char[] str, char[] pattern)
    {
        if (str == null || pattern == null)
            return false;
        int strIndex = 0;
        int patternIndex = 0;
        return mathCore(str, strIndex, pattern, patternIndex);
    }

    private static boolean mathCore(char[] str, int strIndex, char[] pattern, int patternIndex)
    {

        //有效性检验：str到尾，pattern到尾，匹配成功
        if (str.length == strIndex && pattern.length == patternIndex)
            return true;
        //pattern先到尾，匹配失败
        if (str.length != strIndex && pattern.length == patternIndex)
            return false;
        //注意
        //模式第2个是*
        if (patternIndex+1 < pattern.length && pattern[patternIndex + 1] == '*')
        {
            //如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
            if ((str.length != strIndex && str[strIndex] == pattern[patternIndex])
                    || (str.length != strIndex) && pattern[patternIndex] == '*')
            {
                //比如'aba'与'a*ba'、'abc'与'a*c'、'aaa'与'a*aaa'和'aaaba'与'a*ba'
                //匹配0次时，字符串不变，模式向后移动两个字符，然后匹配剩余字符串和模式.
                //匹配1次时，字符串往后移动一个字符，模式向后移动2个字符
                //匹配多次时，字符串往后移动一个字符，模式不变
                return mathCore(str, strIndex, pattern, patternIndex + 2)
                        || mathCore(str, strIndex+1, pattern, patternIndex+2)
                        || mathCore(str, strIndex+1, pattern, patternIndex);
            }
            //如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。 aab c*f
            else
            {
                return mathCore(str, strIndex, pattern, patternIndex+2);
            }
        }
        else
        {
            //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
            if((str.length != strIndex && pattern[patternIndex] == str[strIndex])
                    || (str.length != strIndex && pattern[patternIndex] != '.'))
            {
                return mathCore(str, strIndex+1, pattern, patternIndex+1);
            }
        }
        return false;
    }
}
