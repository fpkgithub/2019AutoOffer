package swordoffer.Thirdchapter;


import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class 深度优先非递归二叉树
{
    public static void main(String[] args)
    {

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        node2.left = node5;
        node2.right = node6;

        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(10);
        node5.right = node7;
        node6.left = node8;

        depthOrderTraversalWithRecursive(root);
        for (int val : res)
        {
            System.out.print(val + " ");
        }
    }


    //深度优先递归二叉树
    private static ArrayList<Integer> res = new ArrayList<Integer>();

    private static void depthOrderTraversalWithRecursive(TreeNode root)
    {
        if (root != null)
        {
            res.add(root.val);
            depthOrderTraversalWithRecursive(root.left);
            depthOrderTraversalWithRecursive(root.right);
        }
    }


    //深度优先非递归二叉树
    private static ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return res;
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            res.add(node.val);
            //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return res;
    }
}


class TreeNode
{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val)
    {
        this.val = val;

    }

}