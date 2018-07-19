package swordoffer.secondchapter;

import java.util.List;

/**
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该节点
 */
public class 在O1时间内删除链表节点
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        printListNode(head);

        ListNode res = DeleteNode(head, node3);

        printListNode(res);
    }

    private static ListNode DeleteNode(ListNode head, ListNode toBeDelete)
    {
        if (head == null || toBeDelete == null || head.next == null)
        {
            return null;
        }
        //要删除的节点不是尾节点
        if (toBeDelete.next != null)
        {
            //如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点，
            // 再删除下一个节点，时间复杂度为 O(1)。
            ListNode node = toBeDelete.next;
            toBeDelete.val = node.val;
            toBeDelete.next = node.next;
        }
        else
        {
            //否则该节点是尾节点，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
            ListNode cur = head;
            while (cur.next != toBeDelete)
            {
                cur = cur.next;
            }
            cur.next = null;
        }
        return head;

    }

    private static void printListNode(ListNode head)
    {
        System.out.println();
        while (head != null)
        {
            System.out.print(head.val);
            head = head.next;
        }
    }
}

class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val)
    {
        this.val = val;
    }
}
