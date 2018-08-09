package swordoffertest;


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


        RandomListNode res = Clone(head);
        while (res != null) {

            System.out.print(res.label + " ");
            res = res.next;
        }
    }

    private static RandomListNode Clone(RandomListNode head) {

        if (head == null)
            return null;

        RandomListNode cur = head;

        //复制
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label );
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        //random
        cur = head;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        //拆分
        cur = head;
        RandomListNode pHead = head.next;
        while (cur.next != null) {
            RandomListNode temp = cur.next;
            cur.next = temp.next;
            //注意：分开拆分，依次往后推
            cur = temp;
        }

        return pHead;

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
