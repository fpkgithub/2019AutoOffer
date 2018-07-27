package swordoffer.Thirdchapter;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 面试题32（一）：不分行从上往下打印二叉树
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
public class 从上往下打印二叉树
{
    public static void main(String[] args)
    {
        /**
         * 先将根节点入队，当前节点是队头节点，将其出队并访问，
         * 如果当前节点的左节点不为空将左节点入队，
         * 如果当前节点的右节点不为空将其入队。
         * 所以出队顺序也是从左到右依次出队。
         */

        ListNode32 root = new ListNode32(5);
        ListNode32 node1 = new ListNode32(3);
        ListNode32 node2 = new ListNode32(8);
        root.left = node1;
        root.right = node2;

        ListNode32 node3 = new ListNode32(1);
        ListNode32 node4 = new ListNode32(4);
        node1.left = node3;
        node1.right = node4;

        ListNode32 node5 = new ListNode32(6);
        ListNode32 node6 = new ListNode32(9);
        node2.left = node5;
        node2.right = node6;

        ListNode32 node7 = new ListNode32(7);
        ListNode32 node8 = new ListNode32(10);
        node5.right = node7;
        node6.left = node8;

        printPre(root);

        System.out.println();

        levelIterator(root);
    }

    private static void levelIterator(ListNode32 root)
    {
        if (root == null)
            return;
        LinkedList<ListNode32> queue = new LinkedList<>();
        queue.offer(root);
        ListNode32 node = null;
        while (!queue.isEmpty())
        {
            node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

    }

    private static void printPre(ListNode32 root)
    {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        printPre(root.left);
        printPre(root.right);
    }

}

class ListNode32
{
    int val;
    ListNode32 left;
    ListNode32 right;

    public ListNode32(int val)
    {
        this.val = val;
    }
}