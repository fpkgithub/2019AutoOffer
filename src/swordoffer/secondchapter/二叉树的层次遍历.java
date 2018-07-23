package swordoffer.secondchapter;

import java.util.LinkedList;

/**
 * 根据层次遍历的顺序，每一层都是从左到右的遍历输出，借助于一个队列。
 */
public class 二叉树的层次遍历
{
    public static void main(String[] args)
    {
        /**
         * 先将根节点入队，当前节点是队头节点，将其出队并访问，
         * 如果当前节点的左节点不为空将左节点入队，
         * 如果当前节点的右节点不为空将其入队。
         * 所以出队顺序也是从左到右依次出队。
         */

        ListNode77 root = new ListNode77(5);
        ListNode77 node1 = new ListNode77(3);
        ListNode77 node2 = new ListNode77(8);
        root.left = node1;
        root.right = node2;

        ListNode77 node3 = new ListNode77(1);
        ListNode77 node4 = new ListNode77(4);
        node1.left = node3;
        node1.right = node4;

        ListNode77 node5 = new ListNode77(6);
        ListNode77 node6 = new ListNode77(9);
        node2.left = node5;
        node2.right = node6;

        ListNode77 node7 = new ListNode77(7);
        ListNode77 node8 = new ListNode77(10);
        node5.right = node7;
        node6.left = node8;

        printPre(root);

        System.out.println();

        levelIterator(root);

    }

    private static void printPre(ListNode77 root)
    {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        printPre(root.left);
        printPre(root.right);
    }

    private static void levelIterator(ListNode77 root)
    {
        if (root == null)
            return;

        LinkedList<ListNode77> queue = new LinkedList<>();
        //queue.add(root);
        queue.offer(root);
        ListNode77 cur = null;
        while (!queue.isEmpty())
        {
            //cur = queue.remove();
            cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null)
                //queue.add(cur.left);
                queue.offer(cur.left);
            if (cur.right != null)
                //queue.add(cur.right);
                queue.offer(cur.right);
        }

    }
}

class ListNode77
{
    int val;
    ListNode77 left;
    ListNode77 right;

    public ListNode77(int val)
    {
        this.val = val;
    }
}
