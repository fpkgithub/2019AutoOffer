package swordoffer.Thirdchapter;

/**
 * 面试题35：复杂链表的复制
 * 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，
 * 复制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
 * 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 * 返回结果为复制后复杂链表的 head。
 */
public class 复杂链表的复制 {

    public static void main(String[] args) {


        RandomListNode head = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(4);
        RandomListNode node4 = new RandomListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;


        RandomListNode[] res = Clone(head);
        while (res[0] != null) {

            System.out.print(res[0].label + " ");
            res[0] = res[0].next;
        }
        System.out.println();
        while (res[1] != null) {

            System.out.print(res[1].label + " ");
            res[1] = res[1].next;
        }


    }

    private static RandomListNode[] Clone(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode cur = head;
        //复制
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label + 11);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        //建立Random
        cur = head;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null)
                clone.random = cur.random.next;
            cur = clone.next;
        }

        //拆分
        cur = head;
        RandomListNode cloneHead = head.next;
        while (cur.next != null) {
            RandomListNode temp = cur.next;
            //注意：分开拆分，依次往后推
            cur.next = temp.next;
            cur = temp;
        }

        RandomListNode[] res = {head, cloneHead};

        return res;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}