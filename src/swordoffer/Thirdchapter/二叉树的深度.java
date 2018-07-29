package swordoffer.Thirdchapter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class 二叉树的深度
{


    //递归
    public int TreeDepth(ListNode322 root)
    {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.left);
        return (left > right ? left : right) + 1;
    }


    //非递归
    public int TreeDepth2(ListNode322 root)
    {
        if (root == null)
            return 0;
        Queue<ListNode322> queue = new LinkedList<>();
        queue.offer(root);
        int dep = 0;
        int count = 0;
        int nextCount = 1;//初始化有root、所以为1
        while (!queue.isEmpty())
        {
            ListNode322 node = queue.poll();
            count++;
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            //一层出队完毕
            if (count == nextCount)
            {
                nextCount = queue.size();
                count = 0;
                dep++;
            }
        }
        return dep;
    }

}
