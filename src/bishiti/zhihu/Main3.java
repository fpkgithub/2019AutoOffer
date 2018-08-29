package bishiti.zhihu;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int arrA[] = new int[n];
        int arrB[] = new int[m];
        for (int i = 0; i < n; i++) {
            arrA[i] = scanner.nextInt();

        }

        for (int i = 0; i < m; i++) {
            arrB[i] = scanner.nextInt();
        }

        SingleList headA = new SingleList(arrA[0]);
        SingleList cur1 = headA;
        for (int i = 1; i < n; i++) {
            SingleList node = new SingleList(arrA[i]);
            cur1.next = node;
            cur1 = node;
        }


        SingleList headB = new SingleList(arrA[0]);
        SingleList cur2 = headB;
        for (int i = 1; i < n; i++) {
            SingleList node = new SingleList(arrB[i]);
            cur2.next = node;
            cur2 = node;
        }

        SingleList res = mergerList(headA, headB);
        SingleList node = null;
        while (res.next != null) {
            node = res;
            System.out.print(res.val + "->");
            res = res.next;

        }
        System.out.print(node.val);
        scanner.close();

    }

    private static SingleList mergerList(SingleList headA, SingleList headB) {

        if (headA == null)
            return headB;
        if (headB == null)
            return headA;

        SingleList cur1 = headA;
        SingleList cur2 = headB;
        SingleList head = cur1;
        while (cur1 != null && cur2 != null) {

            if (cur1.val <= cur2.val) {
                SingleList temp1 = cur1.next;
                SingleList temp2 = cur1.next;
                cur2.next = temp1;
                cur1.next = temp2;

                cur1 = temp1;
                cur2 = temp2;
            }
            else {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        if (cur2 != null) {
            cur1 = cur2.next;
        }
        return head;
    }
}

class SingleList {

    int val = 0;
    SingleList next;

    public SingleList(int val) {
        this.val = val;
    }
}