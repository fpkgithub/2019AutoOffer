package swordoffer.Thirdchapter;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 * 例如，下图是后序遍历序列 3,1,2 所对应的二叉搜索树。
 */
public class 二叉搜索树的后序遍历序列
{
    public static void main(String[] args)
    {
        int[] sequence = {1, 2, 3};
        boolean res = VerifySquenceOfBST(sequence);
        System.out.println(res);
    }

    private static boolean VerifySquenceOfBST(int[] sequence)
    {
        if (sequence == null || sequence.length <= 0)
            return false;
        if (sequence.length == 1)
            return true;
        return verifySearchTree(sequence, 0, sequence.length);
    }

    /*
   采用分治法的思想，找到根结点、左子树的序列、右子树的序列，分别判断左右子序列是否为二叉树的后序序列。

   由题意可得：
   1. 后序遍历序列的最后一个元素为二叉树的根节点；
   2. 二叉搜索树左子树上所有的结点均小于根结点、右子树所有的结点均大于根结点。

   算法步骤如下：
   1. 找到根结点；
   2. 遍历序列，找到第一个大于等于根结点的元素i，则i左侧为左子树、i右侧为右子树；
   3. 我们已经知道i左侧所有元素均小于根结点，那么再依次遍历右侧，看是否所有元素均大于根结点；若出现小于根结点的元素，则直接返回false；若右侧全都大于根结点，则：
   4. 分别递归判断左/右子序列是否为后序序列；
   */
    private static boolean verifySearchTree(int[] sequence, int first, int last)
    {
        if (first >= last)
            return true;
        int root = sequence[last - 1];
        int i = first;
        while (sequence[i] < root)
        {
            i++;
        }
        int j = i;
        while (j < last)
        {
            if (sequence[j] < root)
                return false;
            j++;
        }
        return verifySearchTree(sequence, first, i - 1) && verifySearchTree(sequence, i, last - 1);

    }
}
