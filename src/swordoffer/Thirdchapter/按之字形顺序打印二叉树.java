package swordoffer.Thirdchapter;

import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class 按之字形顺序打印二叉树
{
    public static void main(String[] args)
    {
        int n = 1;
        while (n-- > 0)
        {
            System.out.println("12");
        }
    }

    private static ArrayList<ArrayList<Integer>> print(ListNode322 root)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Queue<ListNode322> queue = new LinkedList<>();

        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty())
        {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0)
            {
                ListNode322 node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (flag)
                Collections.reverse(list);
            flag = !flag;
            if (list.size() != 0)
                res.add(list);
        }
        return res;
    }
}
