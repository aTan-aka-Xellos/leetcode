package tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NTreePreOrderTraversal_589 {

    // recursive
    List<Integer> global = new ArrayList<>();

    public List<Integer> preorder_v1(Node root) {
        if (root == null) return global;

        global.add(root.val);
        for (Node node: root.children){
            preorder_v1(node);
        }
        return global;
    }


    // iterative
    public List<Integer> preorder_v2(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if (root != null) stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);

            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return list;
    }



    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
    }
}
