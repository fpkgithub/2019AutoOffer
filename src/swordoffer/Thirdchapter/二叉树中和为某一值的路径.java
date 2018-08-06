package swordoffer.Thirdchapter;

import java.util.ArrayList;
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
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        ArrayList<ArrayList<Integer>> res = FindPath(root, num);
        for (ArrayList<Integer> re : res) {

            for (Integer val : re) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();

    private static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int num) {
        if (root == null) {
            return res;
        }

        list.add(root.val);
        num -= root.val;
        if (num == 0 && root.left == null && root.right == null) {
            //注意需要新添加一个list到res中
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left, num);
        FindPath(root.right, num);

        //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
        list.remove(list.size() - 1);
        return res;

    }


}


