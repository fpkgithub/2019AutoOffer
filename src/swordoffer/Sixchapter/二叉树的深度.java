package swordoffer.Sixchapter;

/**
 * 55.1二叉树的深度
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */


public class 二叉树的深度 {

    public static void main(String[] args) {

    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;

        int left = depth(node.left);
        int right = depth(node.right);
        return 1 + Math.max(left, right);
    }

}
