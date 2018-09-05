package swordoffer.TreeNodeTest;

import java.util.ArrayList;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    boolean isFirst;

    public TreeNode2(int val) {
        this.val = val;
        isFirst = false;
    }

}

public class 二叉树某一个值的路径 {
    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(5);
        TreeNode2 node1 = new TreeNode2(3);
        TreeNode2 node2 = new TreeNode2(8);
        root.left = node1;
        root.right = node2;

        TreeNode2 node3 = new TreeNode2(1);
        TreeNode2 node4 = new TreeNode2(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode2 node5 = new TreeNode2(6);
        TreeNode2 node6 = new TreeNode2(9);
        node2.left = node5;
        node2.right = node6;


        ArrayList<TreeNode2> res = new ArrayList<>();
        TreeNode2 target = new TreeNode2(6);

        boolean falg = findPath(root, target, res);

        System.out.println(falg);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i).val + " ");
        }
    }

    public static boolean findPath(TreeNode2 root, TreeNode2 target, ArrayList<TreeNode2> list) {

        if (root == null || target == null) {
            return false;
        }

        list.add(root);
        if (root.val == target.val) {
            return true;
        }

        if (root.left != null) {
            if (findPath(root.left, target, list) == true) {
                return true;
            }
        }

        if (root.right != null) {
            if (findPath(root.right, target, list) == true) {
                return true;
            }
        }

        list.remove(list.size() - 1);
        return false;
    }


}
