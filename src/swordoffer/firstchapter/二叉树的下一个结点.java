package swordoffer.firstchapter;


/**
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 */
public class 二叉树的下一个结点
{
    public static void main(String[] args)
    {

        BinaryTreeNode3 tree = new BinaryTreeNode3(1);
        BinaryTreeNode3 res = getNext(tree);
        System.out.println(res.val);
    }

    private static BinaryTreeNode3 getNext(BinaryTreeNode3 pNode)
    {
        //如果右子树不为空，找右子树最左边的节点
        if (pNode.right != null)
        {
            BinaryTreeNode3 node = pNode.right;
            while (node.left != null)
            {
                node = node.left;
            }
            return node;
        }
        else
        {
            //如果右子树为空，则向上找父节点
            while (pNode.left != null)
            {
                BinaryTreeNode3 parent = pNode.next;
                if (parent.left == pNode)
                {
                    return parent;
                }
                pNode = parent;

            }
        }
        return null;
    }
}


class BinaryTreeNode3
{
    int val;
    BinaryTreeNode3 next;
    BinaryTreeNode3 left;
    BinaryTreeNode3 right;

    public BinaryTreeNode3(int val)
    {
        this.val = val;
    }

}