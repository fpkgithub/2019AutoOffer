package swordoffertest;


public class 合并两个排序的链表 {
    public static void main(String[] args) {
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

        ListNode25 res3 = mergerList3(head1, head2);
        while (res3 != null) {
            System.out.print(res3.val + " ");
            res3 = res3.next;
        }
    }

    private static ListNode25 mergerList3(ListNode25 head1, ListNode25 head2) {

        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        if (head1.val <= head2.val) {
            head1.next = mergerList3(head1.next, head2);
            return head1;
        }
        else {
            head2.next = mergerList3(head1, head2.next);
            return head2;
        }
    }
}

class ListNode25 {
    int val;
    ListNode25 next;

    public ListNode25(int val) {
        this.val = val;
    }

}
