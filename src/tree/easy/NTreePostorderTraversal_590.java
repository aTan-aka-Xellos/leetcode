package tree.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NTreePostorderTraversal_590 {

    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Node node;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            node = stack.pop();
            list.addFirst(node.val);
            for (Node n : node.children) {
                stack.push(n);
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
