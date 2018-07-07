package swordoffer.firstchapter;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值v
 */
public class 从尾到头打印链表
{

    public static void main(String[] args)
    {
        SingleNode head = new SingleNode();
        printList(head);
    }

    private static ArrayList<Integer> printList(SingleNode head)
    {
        Stack<Integer> stack = new Stack<Integer>();

        while (head != null)
        {
            stack.push(head.val);
            head = head.next;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.empty())
        {
            list.add(stack.pop());
        }
        return list;
    }

}

class SingleNode
{
    int val;
    SingleNode next;


    public SingleNode()
    {

    }
    public SingleNode(int val)
    {
        this.val = val;
    }
}