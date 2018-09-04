package swordoffer.TreeNodeTest;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class TreeNodeTest {

    //前序非递归遍历
    public void preOrder1(TreeNode root) {

        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.val + " ");
                stack.push(root.left);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }


    //中序非递归
    public void midOrder(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    //后序遍历非递归
    //后序遍历递归定义：先左子树，后右子树，再根节点。
    //后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
    //若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
    //若是位于右子树，则直接访问根节点。

    public ArrayList<Integer> posOrder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        //把后序当作：根->右->左，然后再反转一下即可。
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }


    //后序遍历非递归

    /**
     * 后序遍历的非递归实现比前序、中序的非递归实现 要复杂一点。
     * 需要一个标识来标记某结点是否第一次位于栈顶（该结点的左子树已经遍历完毕，从左子树返回准备遍历它的右子树）
     * 对于后序遍历而言，结点的左右子树都遍历完成之后，才访问该结点。
     * 某结点会两次位于栈顶，第一次是该结点的左子树都遍历完了，然后 获取 栈顶结点，切换到该结点的右孩子，准备遍历它的右子树，
     * 当该结点的右子树也都遍历完后，它就会第二次位于栈顶，此时将栈顶元素出栈。
     */
    public void postOrder(TreeNode root) {

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
                    curNode = curNode.right;
                }
                else {//左右子树都已经访问了
                    tempNode = stack.pop();
                    System.out.print(tempNode.val + " ");
                }
            }
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    boolean isFirst;

    public TreeNode(int val) {
        this.val = val;
        isFirst = false;
    }

}