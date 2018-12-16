package tree.easy;

import static java.util.Collections.reverse;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NTreePreorderTraversalIterative_589 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return list;

        Node node;
        Deque<Node> queue = new LinkedList<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            node = queue.pollFirst();
            list.add(node.val);
            reverse(node.children);
            for (Node n : node.children) {
                queue.addFirst(n);
            }
        }
        return list;
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
