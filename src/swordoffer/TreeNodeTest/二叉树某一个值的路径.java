package swordoffer.TreeNodeTest;

import java.util.ArrayList;

public class 二叉树某一个值的路径 {

    static ArrayList<TreeNode> list = new ArrayList<>();

    public static boolean findPaht(TreeNode node, TreeNode target, ArrayList<TreeNode> list) {
        if (node == target)
            return true;
        if (node.left != null) {
            list.add(node.left);
            if (findPaht(node.left, target, list))
                return true;
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            list.add(node.right);
            if (findPaht(node.left, target, list)) {
                return true;
            }
            list.remove(list.size() - 1);
        }
        return false;
    }

    static ArrayList<TreeNode> list2 = new ArrayList<>();

    public static ArrayList<TreeNode> findPaht2(TreeNode node, TreeNode target) {
        if (node == null) {
            return list2;
        }
        list2.add(node);
        if (node == target) {
            return list2;
        }
        findPaht2(node.left, target);
        findPaht2(node.right, target);

        list2.remove(list.size() - 1);
        return list2;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        node2.left = node5;
        node2.right = node6;

        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(10);
        node5.right = node7;
        node6.left = node8;
        boolean falg = findPaht(root, node2, list);
        System.out.println(falg);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
