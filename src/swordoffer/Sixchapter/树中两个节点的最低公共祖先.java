package swordoffer.Sixchapter;

public class 树中两个节点的最低公共祖先 {

    public static void main(String[] args) {


    }

    //二叉搜索树

    /**
     * 思路：
     * 当前节点大于两个节点，则位于左子树
     * 当前节点小于两个节点，则位于右子树
     * 二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode12 lowerCommonAncestor2(TreeNode12 root, TreeNode12 p, TreeNode12 q) {

        if (root == null)
            return root;
        if (root.val > p.val && root.val > p.val) {
            return lowerCommonAncestor2(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowerCommonAncestor2(root.right, p, q);
        }
        return root;
    }


    //普通二叉树

    /**
     * 在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
     */

    private TreeNode12 lowerCommonAncestor(TreeNode12 root, TreeNode12 p, TreeNode12 q) {
        //发现目标节点则通过返回值标记该子树发现了某个目标节点
        if (root == null || root == q || root == p) {
            return root;
        }
        //查看左子树中是否有目标节点，没有为null
        TreeNode12 left = lowerCommonAncestor2(root.left, p, q);
        //查看右子树中是否有目标节点，没有为null
        TreeNode12 right = lowerCommonAncestor2(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }


    //优化普通二叉树
    private TreeNode12 lowerCommonAncestor11(TreeNode12 root, TreeNode12 p, TreeNode12 q) {

        if (root == null)
            return root;
        if (p.val == root.val || q.val == root.val)
            return root;
        TreeNode12 left = lowerCommonAncestor11(root.left, p, q);
        TreeNode12 right = lowerCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        return left != null ? right : left;
    }

    //

}

class TreeNode12 {
    int val;
    TreeNode12 left;
    TreeNode12 right;

    public TreeNode12(int val) {
        this.val = val;
    }
}