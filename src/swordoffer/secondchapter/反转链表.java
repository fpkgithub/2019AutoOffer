package swordoffer.secondchapter;

/**
 * 面试题24：反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 */
public class 反转链表
{

    public static void main(String[] args)
    {
        ListNode24 head = new ListNode24(1);
        ListNode24 node1 = new ListNode24(2);
        ListNode24 node2 = new ListNode24(3);
        ListNode24 node3 = new ListNode24(4);
        ListNode24 node4 = new ListNode24(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;


        //迭代
        ListNode24 res2 = reverseList2(head);


        //ListNode24 res = reverseList(head);

        //System.out.println(res.val);

        while (res2 != null)
        {
            System.out.print(res2.val + " ");
            res2 = res2.next;
        }
    }


    private static ListNode24 reverseList2(ListNode24 head)
    {
        if (head == null || head.next == null)
            return head;
        ListNode24 pre = null;
        ListNode24 cur = head;
        while (cur != null)
        {
            ListNode24 node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }

        return pre;
    }

    private static ListNode24 reverseList(ListNode24 head)
    {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode24 cur = head.next;
        ListNode24 pre = head;
        pre.next = null;
        while (cur != null)
        {
            ListNode24 temp = cur.next;
            //判断一下头节点
            if (pre.next == null)
            {
                cur.next = pre;
                pre.next = null;
            }
            else
            {
                cur.next = pre;
            }
            pre = cur;
            cur = temp;
        }

        return pre;

    }

}

class ListNode24
{
    int val;
    ListNode24 next;

    public ListNode24(int val)
    {
        this.val = val;
    }
}
