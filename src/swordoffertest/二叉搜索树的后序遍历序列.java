package swordoffertest;

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
        return verifyCore(sequence, 0, sequence.length);

    }

    private static boolean verifyCore(int[] sequence, int start, int end)
    {
        if (start >= end)
            return true;
        int root = sequence[end - 1];
        int i = start;
        while (sequence[i] < root)
        {
            i++;
        }
        int j = i;
        while (j < end)
        {
            if (sequence[j] < root)
            {
                return false;
            }
            j++;
        }
        return verifyCore(sequence, start, i - 1) && verifyCore(sequence, j, end - 1);
    }
}

