package swordoffer.firstchapter;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。队列中的元素为 int 类型
 * <p>
 * in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。
 * 一个元素进入 in 栈之后，出栈的顺序被反转。当元素要出栈时，需要先进入 out 栈，
 * 此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，
 * 先进入的元素先退出，这就是队列的顺序。
 * </p>
 */
public class 用两个栈实现队列
{

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node)
    {
        stack1.push(node);
    }


    public int pop() throws Exception
    {
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.size() == 0)
        {
            throw new Exception("is empty");
        }

        return stack2.pop();

    }

}
