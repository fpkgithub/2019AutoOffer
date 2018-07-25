package swordoffer.secondchapter;

/**
 * 面试题26：树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class 树的子结构
{
    public static void main(String[] args)
    {

        TreeNode26 root1 = new TreeNode26(8);
        TreeNode26 node1 = new TreeNode26(8);
        TreeNode26 node2 = new TreeNode26(7);
        TreeNode26 node3 = new TreeNode26(9);
        TreeNode26 node4 = new TreeNode26(2);
        TreeNode26 node5 = new TreeNode26(4);
        TreeNode26 node6 = new TreeNode26(7);

        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        node6.left = null;
        node6.right = null;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;

        TreeNode26 root2 = new TreeNode26(8);
        TreeNode26 node7 = new TreeNode26(9);
        TreeNode26 node8 = new TreeNode26(2);

        root2.left = node7;
        root2.right = node8;
        node7.left = null;
        node7.right = null;
        node8.left = null;
        node8.right = null;


        boolean res = hasSubTree(root1, root2);
        System.out.println(res);
    }

    //思路：
    //1：在树A中找到和树B的根节点值一样的节点R
    //2：判断A中以R为根节点的子树是不是包含和树B一样的结构
    private static boolean hasSubTree(TreeNode26 root1, TreeNode26 root2)
    {

        if (root1 == null || root2 == null)
            return false;
        return isSubtreeWithRoot(root1, root2) || hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    private static boolean isSubtreeWithRoot(TreeNode26 root1, TreeNode26 root2)
    {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isSubtreeWithRoot(root1.left, root2.left) && isSubtreeWithRoot(root1.right, root2.right);
    }
}

class TreeNode26
{
    int val = 0;
    TreeNode26 left = null;
    TreeNode26 right = null;

    public TreeNode26(int val)
    {
        this.val = val;
    }

}

