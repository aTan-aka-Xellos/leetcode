package tree.easy;

import java.util.ArrayList;
import java.util.List;

public class NTreePreorderTraversalRecursive_589 {

    private List<Integer> list = new ArrayList<>();



    public List<Integer> preorder(Node root) {
        getIndex(root);
        return list;
    }

    private void getIndex(Node root) {
        if (root == null) return;

        list.add(root.val);
        for (Node node : root.children) {
            getIndex(node);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
