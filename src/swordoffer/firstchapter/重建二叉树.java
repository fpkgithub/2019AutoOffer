package swordoffer.firstchapter;

import java.util.Arrays;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 * 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
 * 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
 * 图2.6所示的二叉树并输出它的头结点。
 */
public class 重建二叉树 {

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        BinaryTreeNode2 res = buildTree(pre, in);

        prePrint(res);

    }

    //9 15 7 20 3
    private static void prePrint(BinaryTreeNode2 res) {

        if (res == null)
            return;

        prePrint(res.left);
        prePrint(res.right);
        System.out.println(res.val);
    }

    //preorder = [3,9,20,15,7]
    //inorder =  [9,3,15,20,7]
    //前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，
    // 左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
    private static BinaryTreeNode2 buildTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }


        BinaryTreeNode2 root = new BinaryTreeNode2(pre[0]);

        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                root.left = buildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = buildTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }

        return root;
    }


}

class BinaryTreeNode2 {
    int val;
    BinaryTreeNode2 left;
    BinaryTreeNode2 right;

    public BinaryTreeNode2(int val) {
        this.val = val;
    }

}