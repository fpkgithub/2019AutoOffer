package swordoffer.Thirdchapter;

/**
 * 面试题28：对称的二叉树
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
 * 它的镜像一样，那么它是对称的。
 */
public class 对称的二叉树
{


    public static void main(String[] args)
    {

        TreeNode28 root = new TreeNode28(8);
        TreeNode28 node1 = new TreeNode28(6);
        TreeNode28 node2 = new TreeNode28(6);
        TreeNode28 node3 = new TreeNode28(5);
        TreeNode28 node4 = new TreeNode28(7);
        TreeNode28 node5 = new TreeNode28(7);
        TreeNode28 node6 = new TreeNode28(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;


        boolean res = isSymmetrical(root);
        System.out.println(res);
    }

    //思路：
    //通过比较二叉树的前序遍历和对称前序遍历来判断二叉树是不是对称的
    private static boolean isSymmetrical(TreeNode28 root)
    {

        if (root == null)
            return true;
        return isSymmetricalCore(root.left, root.right);

    }

    private static boolean isSymmetricalCore(TreeNode28 r1, TreeNode28 r2)
    {
        if (r1 == null && r2 == null)
            return true;
        if (r1 == null || r2 == null)
            return false;
        if (r1.val != r2.val)
            return false;
        return isSymmetricalCore(r1.left, r2.right) && isSymmetricalCore(r1.right, r2.left);
    }

}

class TreeNode28
{
    int val;
    TreeNode28 left;
    TreeNode28 right;

    public TreeNode28(int val)
    {
        this.val = val;
    }
}
