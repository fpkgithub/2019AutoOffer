package swordoffer.TreeNodeTest;


import java.util.ArrayList;

/**
 * 静波
 */
public class PathFromRoot {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(52);
        bt.insert(580);
        bt.insert(12);
        bt.insert(50);
        bt.insert(58);
        bt.insert(9);
        bt.insert(888);
        bt.insert(248);
        bt.insert(32);
        bt.insert(666);
        bt.insert(455);
        bt.insert(777);
        bt.insert(999);


        //Node target = new Node(455);
        Node target = new Node(455);
        ArrayList<Node> arrayList = new ArrayList<>();

        bt.postOrderByStack();


        boolean flag = helper(bt.findKey(52), target, arrayList);

        System.out.println(flag);

        for (Node t : arrayList) {
            System.out.println(t.value);
        }

    }

    public static boolean helper(Node root, Node node, ArrayList<Node> path) {

        if (root == null || node == null) {
            return false;
        }

        path.add(root);

        if (root.value == node.value) {
            //path.add(root);
            return true;
        }

        if (root.leftChild != null) {
            if (helper(root.leftChild, node, path) == true) {
                //path.add(root.left);
                return true;
            }
        }

        if (root.rightChild != null) {
            if (helper(root.rightChild, node, path) == true) {
                //path.add(root.right);
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;

    }

}
