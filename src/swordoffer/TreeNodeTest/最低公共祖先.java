package swordoffer.TreeNodeTest;

import javax.xml.soap.Text;
import java.util.ArrayList;

public class 最低公共祖先 {

    //思路：
    // 保存由root根节点到p和q节点的路径，并且将路径存入list中，
    // 则问题转化为求两个list集合的最后一个共同元素。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;

        ArrayList<TreeNode> pathP = new ArrayList<>();
        pathP.add(p);

        ArrayList<TreeNode> pathQ = new ArrayList<>();
        pathQ.add(q);

        getPath(root, p, pathP);
        getPath(root, q, pathQ);

        for (int i = 0; i < pathP.size() && i < pathQ.size(); i++) {
            if (pathP.get(i) == pathQ.get(i)) {
                lca = pathP.get(i);
            }
            else {
                break;
            }
        }
        return lca;
    }

    private boolean getPath(TreeNode root, TreeNode target, ArrayList<TreeNode> path) {
        if (root == null || target == null) {
            return false;
        }
        path.add(root);
        if (root.val == target.val)
            return true;
        if (root.left != null)
            if (getPath(root.left, target, path) == true)
                return true;

        if (root.right != null)
            if (getPath(root.right, target, path) == true)
                return true;
        path.remove(path.size() - 1);
        return false;
    }
}