package swordoffer.Sixchapter;

/**
 * 面试题55（二）：平衡二叉树
 * 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
 * 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class 平衡二叉树 {


    private boolean isBalance = true;

    private boolean isBalanceTree(TreeNode root) {

        int h = height(root);
        System.out.println(h);
        return isBalance;
    }

    private int height(TreeNode root) {

        if (root == null || !isBalance)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return 1 + Math.max(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}