package swordoffer.Thirdchapter;

import java.util.Stack;

/**
 * 面试题31：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
 * 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
 * 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
 * 4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
public class 栈的压入弹出序列
{
    public static void main(String[] args)
    {
        int[] pushSequence = {1, 2, 3, 4, 5};
        int[] popSequence = {4, 5, 3, 2, 1};
        boolean res = isPopOrder(pushSequence, popSequence);
        System.out.println(res);
    }

    public static boolean isPopOrder(int[] pushSequence, int[] popSequence)
    {
        if (popSequence.length <= 0 || pushSequence.length <= 0 || popSequence.length != pushSequence.length)
            return false;

        //思路：借助stack入栈和出栈
        int len = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int pushIndex = 0; pushIndex < len; pushIndex++)
        {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < len && stack.peek() == popSequence[popIndex])
            {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }
}
