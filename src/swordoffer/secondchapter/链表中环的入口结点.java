package swordoffer.secondchapter;

import java.util.List;

/**
 * 面试题23：链表中环的入口结点
 * 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * 环的入口结点是结点3。
 * 1-->2-->3-->4-->5-->6
 * ********|___________|
 */

public class 链表中环的入口结点
{
    public static void main(String[] args)
    {
        ListNode23 head = new ListNode23(1);
        ListNode23 node1 = new ListNode23(2);
        ListNode23 node2 = new ListNode23(3);
        ListNode23 node3 = new ListNode23(4);
        ListNode23 node4 = new ListNode23(5);
        ListNode23 node5 = new ListNode23(6);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        //传统offer方法
        ListNode23 res = EntryNodeOfLoop(head);
        System.out.println(res.val);

        //公式：x+2y+z=2(x+y)，得到 x=z
        ListNode23 res2 = EntryNodeOfLoop2(head);
        System.out.println(res2.val);
    }

    /**
     * 使用双指针，一个指针 fast 每次移动两个节点，一个指针 slow 每次移动一个节点。因为存在环，所以两个指针必定相遇在环中的某个节点上。
     * 假设相遇点在下图的 z1 位置，此时 fast 移动的节点数为 x+2y+z，slow 为 x+y，由于 fast 速度比 slow 快一倍，
     * 因此 x+2y+z=2(x+y)，得到 x=z。
     * 在相遇点，slow 要到环的入口点还需要移动 z 个节点，如果让 fast 重新从头开始移动，并且速度变为每次移动一个节点，
     * 那么它到环入口点还需要移动 x 个节点。在上面已经推导出 x=z，因此 fast 和 slow 将在环入口点相遇。
     *
     * @param head
     * @return
     */
    private static ListNode23 EntryNodeOfLoop2(ListNode23 head)
    {
        if (head == null || head.next == null)
            return null;
        ListNode23 fast = head;
        ListNode23 slow = head;
        //因为fast每次要走两步，所有需要判断fast的下一个是否为空
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            //第一次相遇则跳出
            if (slow.val == fast.val)
                break;
        }
        //判断是否相遇 相遇后让快指针从头开始走，每次都是走一步，第二次相遇的节点就是环的入口
        fast = head;
        while (fast.val != slow.val)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private static ListNode23 EntryNodeOfLoop(ListNode23 head)
    {
        if (head == null)
            return null;
        //第一步：在确定有环的时候，找到快慢指针相遇的节点
        ListNode23 slow = head.next;
        if (slow == null)
            return null;
        ListNode23 fast = head.next.next;
        if (fast == null)
            return null;
        while (fast != null && slow != null)
        {
            if (fast.val == slow.val)
            {
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }

        //第二步：确定环的节点数K
        int countNode = 1;
        ListNode23 pNode = fast;
        while (pNode.next != fast)
        {
            pNode = pNode.next;
            countNode++;
        }

        //移动指针，使其间距为countNode
        pNode = head;
        for (int i = 0; i < countNode; i++)
        {
            pNode = pNode.next;
        }

        //第三步：两个指针以K的步距移动，若相遇则相遇点就是入口点
        ListNode23 pNode2 = head;
        while (pNode.val != pNode2.val)
        {
            pNode = pNode.next;
            pNode2 = pNode2.next;
        }

        return pNode;
    }
}

class ListNode23
{
    int val;
    ListNode23 next;

    public ListNode23(int val)
    {
        this.val = val;
    }
}
