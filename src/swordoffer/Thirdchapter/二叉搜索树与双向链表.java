package swordoffer.Thirdchapter;

/**
 * 面试题36：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class 二叉搜索树与双向链表 {

    public static void main(String[] args) {
        TreeNode36 root = new TreeNode36(10);

        TreeNode36 node1 = new TreeNode36(6);
        TreeNode36 node2 = new TreeNode36(14);
        TreeNode36 node3 = new TreeNode36(4);
        TreeNode36 node4 = new TreeNode36(8);
        TreeNode36 node5 = new TreeNode36(12);
        TreeNode36 node6 = new TreeNode36(16);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        TreeNode36 res = convert(root);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.right;
        }


    }

    //中序遍历
    private static TreeNode36 pre = null;//前一个指针
    private static TreeNode36 head = null;

    private static TreeNode36 convert(TreeNode36 root) {
        if (root == null)
            return null;
        convertCore(root);
        return head;
    }

    private static void convertCore(TreeNode36 node) {
        if (node == null) {
            return;
        }
        convertCore(node.left);
        //构建前指针
        node.left = pre;
        if (node.left != null) {
            //构建后指针
            pre.right = node;
        }
        //后移
        pre = node;
        //头节点
        if (head == null) {
            head = node;
        }
        convertCore(node.right);
    }
}


class TreeNode36 {

    int val = 0;
    TreeNode36 left = null;
    TreeNode36 right = null;

    public TreeNode36(int val) {
        this.val = val;
    }

}
