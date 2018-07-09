package swordoffertest;

import java.util.Arrays;

public class 重建二叉树
{

    public static void main(String[] args)
    {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        BinaryTreeNode2 res = buildBinaryTree(pre, in);
        prePrint(res);

    }

    //9 15 7 20 3
    private static void prePrint(BinaryTreeNode2 res)
    {

        if (res == null)
            return;

        prePrint(res.left);
        prePrint(res.right);
        System.out.println(res.val);
    }

    private static BinaryTreeNode2 buildBinaryTree(int[] pre, int[] in)
    {

        if (pre.length == 0 || in.length == 0)
            return null;
        BinaryTreeNode2 root = new BinaryTreeNode2(pre[0]);
        for (int i = 0; i < in.length; i++)
        {
            if (pre[0] == in[i])
            {
                root.left = buildBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = buildBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}


class BinaryTreeNode2
{
    int val;
    BinaryTreeNode2 left;
    BinaryTreeNode2 right;

    public BinaryTreeNode2(int val)
    {
        this.val = val;
    }

}
