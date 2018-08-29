package bishiti.Zhongxin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String network = scanner.nextLine();

        int[] res = getLenForNode(network);

        scanner.close();

    }

    private static int[] getLenForNode(String network) {

        int len = network.length();
        int[] res = new int[len];

        //构建二叉树
        char[] arr2 = network.toCharArray();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(arr[i] + "");
        }



        return res;
    }


    private static void printPre(TreeNode7 head) {

        if (head == null)
            return;
        System.out.print(head.val + " ");
        printPre(head.left);
        printPre(head.right);
    }


    public LinkedList<TreeNode7> helper(TreeNode7 n, TreeNode7 p, TreeNode7 q) {
        if (n == null) {
            return null;
        }

        LinkedList<TreeNode7> left = helper(n.left, p, q);
        LinkedList<TreeNode7> right = helper(n.right, p, q);

        // 当左右都为空时
        if (left == null && right == null) {
            // 如果当前节点是目标节点，开启一条新路径
            if (n == p || n == q) {
                LinkedList l = new LinkedList<TreeNode7>();
                l.add(n);
                return l;
            }
            else {
                // 否则标记为空
                return null;
            }
            // 如果左右节点都不为空，说明是最小公共祖先节点，合并两条路径
        }
        else if (left != null && right != null) {
            Collections.reverse(right);
            return left;
            // 如果当前节点是目标结点，且某一个子树不为空时，说明最小公共祖先是节点自身
        }
        else if (left != null) {
            left.add(n);
            return left;
        }
        else {
            right.add(n);
            return right;
        }
    }

}

class Res {
    int max;
}

class TreeNode7 {
    int val = 0;
    TreeNode7 left;
    TreeNode7 right;

    public TreeNode7(int val) {
        this.val = val;
    }
}