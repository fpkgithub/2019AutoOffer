package swordoffer.Thirdchapter;

/**
 * 面试题27：二叉树的镜像
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class 二叉树的镜像
{
    public static void main(String[] args)
    {
        //先序遍历节点,如果当前结点不为空，则交换
        TreeNode27 root = new TreeNode27(1);
        TreeNode27 node1 = new TreeNode27(2);
        TreeNode27 node2 = new TreeNode27(3);

        root.left = node1;
        root.right = node2;

        prePrintTree(root);
        System.out.println();
        mirror(root);
        prePrintTree(root);
    }

    private static void prePrintTree(TreeNode27 res)
    {
        if (res == null)
            return;
        System.out.print(res.val + " ");
        prePrintTree(res.left);
        prePrintTree(res.right);
    }

    private static void mirror(TreeNode27 root)
    {
        //先序遍历节点,如果当前结点不为空，则交换
        if (root == null)
            return;
        TreeNode27 node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left != null)
            mirror(root.left);
        if (root.right != null)
            mirror(root.right);
    }
}

class TreeNode27
{
    int val;
    TreeNode27 left;
    TreeNode27 right;

    public TreeNode27(int val)
    {
        this.val = val;
    }
}

