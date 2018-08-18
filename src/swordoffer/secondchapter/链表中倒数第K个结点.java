package swordoffer.secondchapter;

/**
 * 面试题22：链表中倒数第k个结点
 * 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * 值为4的结点。
 */
public class 链表中倒数第K个结点 {
    public static void main(String[] args) {

        int k = 3;

        ListNode22 head = new ListNode22(1);
        ListNode22 node1 = new ListNode22(2);
        ListNode22 node2 = new ListNode22(3);
        ListNode22 node3 = new ListNode22(4);
        ListNode22 node4 = new ListNode22(5);
        ListNode22 node5 = new ListNode22(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode22 res = FindTheToTail(head, k);
        System.out.println(res.val);
    }

    private static ListNode22 FindTheToTail(ListNode22 head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode22 cur = head;
        while (cur != null && k-- > 0) {
            cur = cur.next;
        }
        if (k > 0)
            return null;
        ListNode22 pre = head;
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
        /*
        for (int i = 1; i < k; i++)
        {
            //注意是next
            if (cur.next != null)
            {
                cur = cur.next;
            }
            else//不足K个节点
            {
                return null;
            }
        }

        ListNode22 lastKNode = head;
        //先检查后下一步
        while (cur.next != null) {
            cur = cur.next;
            lastKNode = lastKNode.next;
        }
         return lastKNode;
        */
    }
}

class ListNode22 {
    int val;
    ListNode22 next;

    public ListNode22(int val) {
        this.val = val;
    }
}
