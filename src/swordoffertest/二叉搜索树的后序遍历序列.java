package swordoffertest;

public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3};
        boolean res = VerifySquenceOfBST(sequence);
        System.out.println(res);
    }

    private static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        if (sequence.length == 1)
            return true;
        return verifyCore(sequence, 0, sequence.length);
    }

    private static boolean verifyCore(int[] sequence, int left, int right) {
        if (left >= right)
            return true;
        int root = sequence[right - 1];
        int i = left;
        while (sequence[i] < root) {
            i++;
        }
        int j = i;
        while (j < right) {
            if (sequence[j] < root)
                return false;
            j++;
        }

        return verifyCore(sequence, left, i - 1) && verifyCore(sequence, i, right - 1);

    }
}

