package swordoffer.Thirdchapter;

import java.util.Stack;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 */
public class 包含min函数的栈
{
    //数据栈
    private Stack<Integer> dataStack = new Stack<>();
    //辅助栈
    private Stack<Integer> minStack = new Stack<>();


    public void pop()
    {
        dataStack.pop();
        minStack.pop();
    }

    public void push(int data)
    {
        dataStack.push(data);
        if (!minStack.empty() && minStack.peek() < data)
        {
            data = minStack.peek();
        }
        minStack.push(data);
    }

    public void top()
    {
        dataStack.peek();
    }

    public void min()
    {
        minStack.peek();
    }

}
