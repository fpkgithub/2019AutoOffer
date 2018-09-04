package swordoffer.TreeNodeTest;

import java.util.Stack;

/**
 * 4
 */

public class 二叉树非递归遍历 {

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


        preOrder1(root);

        System.out.println();

        inOrder(root);

        System.out.println();

        postOrder2(root);


    }

    public static void preOrder1(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root); //存着为了后面的出栈 左节点和右节点
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void inOrder(TreeNode node) {
        if (node == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }


    //后序遍历
    public static void postOrder2(TreeNode root) {

        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        TreeNode tempNode = null;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                //获得栈顶元素
                tempNode = stack.peek();
                //从左子树返回,需要判断它的右子树是否已经访问了
                if (tempNode.isFirst == false) { //右子树还未被访问
                    tempNode.isFirst = true;
                    curNode = tempNode.right;
                }
                else {//左右子树都已经访问了
                    tempNode = stack.pop();
                    System.out.print(tempNode.val + " ");
                }
            }
        }
    }

    //后序遍历

    /**
     * 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
     * 如果P不存在左孩子和右孩子，则可以直接访问它；
     * 或者P存在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
     * 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了每次取栈顶元素的时候，
     * 左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     */
    public static void postOrder1(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = null;
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            curNode = stack.peek();
            if ((curNode.left == null && curNode.right == null) || (pre != null && (curNode.left == pre || curNode.right == pre))) {
                TreeNode temp = stack.pop();
                System.out.print(temp.val + "");
                pre = temp;
            }
            else {
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
                if (curNode.left != null) {
                    stack.push(curNode.left);
                }
            }
        }
    }
}
