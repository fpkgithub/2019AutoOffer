package swordoffer.Thirdchapter;

import java.util.Stack;

public class 二叉树的深度优先遍历 {
    public void depthOrderTraversal(TreeNode root) {

        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }
}
