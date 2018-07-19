package swordoffer.secondchapter;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中重复的结点
{
    public static void main(String[] args)
    {
        ListNode2 head = new ListNode2(1);
        ListNode2 node1 = new ListNode2(2);
        ListNode2 node2 = new ListNode2(3);
        ListNode2 node3 = new ListNode2(3);
        ListNode2 node4 = new ListNode2(4);
        ListNode2 node5 = new ListNode2(4);
        ListNode2 node6 = new ListNode2(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        printListNode(head);

        //ListNode2 res = deleteDuplication(head);
        ListNode2 res = deleteDuplication2(head);

        printListNode(res);
    }

    //递归解法
    private static ListNode2 deleteDuplication(ListNode2 head)
    {

        //只有0个或1个结点，则返回
        if (head == null || head.next == null)
            return head;
        //当前节点是重复节点时
        if (head.val == head.next.val)
        {
            ListNode2 node = head.next;
            while (node != null && head.val == node.val)
            {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                node = node.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication(node);
        }
        else
        {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }

    //非递归解法
    private static ListNode2 deleteDuplication2(ListNode2 head)
    {
        //考虑头节点右重复数字的情况，新建一个头结点
        //设置一个trick 值为-1，定义一个first对象:主要用于返回操作后的链表
        ListNode2 first = new ListNode2(-1);
        first.next = head;
        //定义一个last同样指向first（主要用于操作记录要删除节点的前一个节点）
        ListNode2 last = first;
        //当前节点
        ListNode2 cur = head;

        while (cur != null && cur.next != null)
        {
            //前后相等
            if (cur.val == cur.next.val)
            {
                int val = cur.val;
                while (cur != null && cur.val == val)
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

    private static void printListNode(ListNode2 res)
    {
        System.out.println();
        while (res != null)
        {
            System.out.print(res.val);
            res = res.next;
        }
    }
}

class ListNode2
{
    int val;
    ListNode2 next;

    public ListNode2(int val)
    {
        this.val = val;
    }
}