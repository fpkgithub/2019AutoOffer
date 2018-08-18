package swordoffer.firstchapter;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值v
 */
public class 从尾到头打印链表 {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        SingleNode node1 = new SingleNode(2);
        SingleNode node2 = new SingleNode(3);
        SingleNode node3 = new SingleNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ArrayList<Integer> list = printList2(head);
        for (Integer val : list) {
            System.out.println(val);
        }
    }

    //使用栈
    private static ArrayList<Integer> printList(SingleNode head) {
        Stack<Integer> stack = new Stack<Integer>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    //使用递归
    static ArrayList<Integer> list = new ArrayList<Integer>();

    /*private static ArrayList<Integer> printList2(SingleNode node) {
        if (node != null) {
            if (node.next != null) {
                list = printList2(node.next);
            }
            list.add(node.val);
        }
        return list;
    }*/

    private static ArrayList<Integer> printList2(SingleNode node) {

        if (node != null) {
            if (node.next != null) {
                list = printList2(node.next);
                list.add(node.val);
            }
        }
        return list;

    }


}

class SingleNode {
    int val;
    SingleNode next;


    public SingleNode() {
    }

    public SingleNode(int val) {
        this.val = val;
    }
}