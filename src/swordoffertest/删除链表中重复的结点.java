package swordoffertest;

public class 删除链表中重复的结点
{
    public static void main(String[] args)
    {
        ListNode3 head = new ListNode3(1);
        ListNode3 node1 = new ListNode3(2);
        ListNode3 node2 = new ListNode3(3);
        ListNode3 node3 = new ListNode3(3);
        ListNode3 node4 = new ListNode3(4);
        ListNode3 node5 = new ListNode3(4);
        ListNode3 node6 = new ListNode3(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        printListNode(head);

        ListNode3 res = deleteDuplication(head);

        printListNode(res);


    }


    private static ListNode3 deleteDuplication2(ListNode3 head)
    {
        //0 1
        if (head == null && head.next == null)
            return head;
        if (head.val == head.next.val)
        {
            ListNode3 node = head.next;
            while (node != null && node.val == head.val)
            {
                node = node.next;
            }
            return deleteDuplication(node);
        }
        else
        {
            head.next = deleteDuplication2(head.next);
            return head;
        }
    }

    private static ListNode3 deleteDuplication(ListNode3 head)
    {
        //新添加一个头节点
        ListNode3 first = new ListNode3(-1);
        first.next = head;
        ListNode3 last = first;
        ListNode3 cur = head;
        while (cur != null && cur.next != null)
        {
            if (cur.val == cur.next.val)
            {
                int value = cur.val;
                while (cur != null && cur.val == value)
                {
                    cur = cur.next;
                }
                last.next = cur;
            }
            else
            {
                last = cur;
                cur = cur.next;
            }
        }
        return first.next;
    }

    private static void printListNode(ListNode3 head)
    {
        System.out.println();
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}

class ListNode3
{
    int val;
    ListNode3 next;

    public ListNode3(int val)
    {
        this.val = val;
    }
}