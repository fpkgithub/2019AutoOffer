package swordoffer.Thirdchapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题32（二）：分行从上到下打印二叉树
 * 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
 * 打印到一行。
 */
public class 把二叉树打印成多行
{
    public static void main(String[] args)
    {
        ListNode322 root = new ListNode322(5);
        ListNode322 node1 = new ListNode322(3);
        ListNode322 node2 = new ListNode322(8);
        root.left = node1;
        root.right = node2;

        ListNode322 node3 = new ListNode322(1);
        ListNode322 node4 = new ListNode322(4);
        node1.left = node3;
        node1.right = node4;

        ListNode322 node5 = new ListNode322(6);
        ListNode322 node6 = new ListNode322(9);
        node2.left = node5;
        node2.right = node6;

        ListNode322 node7 = new ListNode322(7);
        ListNode322 node8 = new ListNode322(10);
        node5.right = node7;
        node6.left = node8;

        printPre(root);

        System.out.println();

        ArrayList<ArrayList<Integer>> res = levelIterator(root);
        for (ArrayList<Integer> re : res)
        {

            for (int val : re)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    //队列LinkedList完成层序遍历，用end记录每层结点数目

    /**
     *  *按层次输出二叉树
     *  *访问根节点，并将根节点入队。
     *  *当队列不空的时候，重复以下操作。
     *  *1、弹出一个元素。作为当前的根节点。
     *  *2、如果根节点有左孩子，访问左孩子，并将左孩子入队。
     *  *3、如果根节点有右孩子，访问右孩子，并将右孩子入队。
     **/
    private static ArrayList<ArrayList<Integer>> levelIterator(ListNode322 root)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        //使用队列, 先进先出
        Queue<ListNode322> queue = new LinkedList<>();
        //存放每行的列表
        ArrayList<Integer> layerList = new ArrayList<>();

        queue.offer(root);
        //记录本层打印了多少个
        int start = 0;
        //记录下层节点数目
        int end = 1;
        while (!queue.isEmpty())
        {
            ListNode322 node = queue.poll();
            //添加到本行的arrayList
            layerList.add(node.val);
            start++;
            //每打印一个节点，就把此节点的下一层的左右节点加入队列，并记录下一层要打印的个数
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            //判断本层打印是否完成
            if (start == end)
            {
                //此时的queue中存储的都是下一层的节点，则end即为queue大小
                end = queue.size();
                start = 0;
                //把arrayList添加到结果列表arrayLists中
                res.add(layerList);
                //重置arrayList
                layerList = new ArrayList<>();
            }
        }
        return res;
    }

    private static void printPre(ListNode322 root)
    {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        printPre(root.left);
        printPre(root.right);
    }
}

class ListNode322
{
    int val;
    ListNode322 left;
    ListNode322 right;

    public ListNode322(int val)
    {
        this.val = val;
    }
}