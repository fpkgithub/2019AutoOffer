package swordoffer.Thirdchapter;

import java.util.Map;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 下图的二叉树有两条和为 22 的路径：10, 5, 7 和 10, 12
 */
public class 二叉树中和为某一值的路径 {

    public static void main(String[] args) {

        int num = 22;
        TreeNode root = new TreeNode(10);
        FindPath(root, num);

    }

    private static void FindPath(TreeNode root, int num) {


    }


}


