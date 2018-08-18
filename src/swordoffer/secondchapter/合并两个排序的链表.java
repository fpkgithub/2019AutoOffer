package swordoffer.secondchapter;

/**
 * 面试题25：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
 * 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
 * 表3所示。
 * 1:  1  3  5  7
 * 2： 2  4  6  8
 * 3： 1  2  3  4  5  6  7  8
 */
public class 合并两个排序的链表
{
    public static void main(String[] args)
    {
        ListNode25 head1 = new ListNode25(1);
        ListNode25 node2 = new ListNode25(3);
        ListNode25 node3 = new ListNode25(5);
        ListNode25 node4 = new ListNode25(7);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode25 head2 = new ListNode25(2);
        ListNode25 n1 = new ListNode25(4);
        ListNode25 n2 = new ListNode25(6);
        ListNode25 n3 = new ListNode25(8);

        head2.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = null;


        //方法一
        //ListNode25 res = mergerList(head1, head2);
        /*while (res != null)
        {
            System.out.print(res.val + " ");
            res = res.next;
        }*/


        //方法二
        /*ListNode25 res2 = mergerList2(head1, head2);

        while (res2 != null)
        {
            System.out.print(res2.val + " ");
            res2 = res2.next;
        }*/

        //递归
        ListNode25 res3 = mergerList3(head1, head2);
        while (res3 != null)
        {
            System.out.print(res3.val + " ");
            res3 = res3.next;
        }

    }

    private static ListNode25 mergerList3(ListNode25 head1, ListNode25 head2)
    {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.val <= head2.val)
        {
            head1.next = mergerList3(head1.next, head2);
            return head1;
        }
        else
        {
            head2.next = mergerList3(head1, head2.next);
            return head2;
        }
    }

    private static ListNode25 mergerList2(ListNode25 head1, ListNode25 head2)
    {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        ListNode25 head = new ListNode25(-1);
        ListNode25 cur = head;
        while (head1 != null && head2 != null)
        {
            if (head1.val <= head2.val)
            {
                cur.next = head1;
                head1 = head1.next;
            }
            else
            {
                cur.next = head2;
                head2 = head2.next;
            }
            //注意别忘记next下移
            cur = cur.next;
        }
        if (head1 != null)
        {
            cur.next = head1;
        }
        if (head2 != null)
        {
            cur.next = head2;
        }
        return head.next;
    }

    private static ListNode25 mergerList(ListNode25 head1, ListNode25 head2)
    {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        ListNode25 cur1 = head1;
        ListNode25 cur2 = head2;
        ListNode25 head = cur1;
        while (cur1 != null && cur2 != null)
        {

            if (cur1.val < cur2.val)
            {
                ListNode25 node1 = cur1.next;
                ListNode25 node2 = cur2.next;
                cur2.next = node1;
                cur1.next = cur2;

                cur1 = node1;
                cur2 = node2;
            }
            else
            {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

        }
        if (cur2 != null)
            cur1 = cur2.next;
        return head;
    }
}

class ListNode25
{
    int val;
    ListNode25 next;

    public ListNode25(int val)
    {
        this.val = val;
    }

}



