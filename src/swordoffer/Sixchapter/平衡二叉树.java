package swordoffer.Sixchapter;

/**
 * 平衡二叉树左右子树高度差不超过 1。
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