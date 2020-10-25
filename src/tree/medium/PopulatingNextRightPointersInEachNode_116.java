package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode_116 {

    // 10/25/2020
    public Node connect_v1(Node root) {
        if (root == null || root.left == null) return root;
        root.left.next  = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        connect_v1(root.left);
        connect_v1(root.right);
        return root;
    }

    // 07/22/2020
    public Node connect_v2(Node root) {

        Queue<Node> queue = new LinkedList<>();

        if (root != null) queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                if (size > 1) node.next = queue.peek();

                if (node.left  != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }
        return root;
    }


    // from https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37473/My-recursive-solution(Java)/188548
    public Node _connect(Node root) {
        if (root == null || root.left == null) return root;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        _connect(root.left);
        _connect(root.right);
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
