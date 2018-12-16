package tree.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NTreeLevelOrderTraversal_429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> sublist = new LinkedList<>();
            list.add(sublist);

            for (int i = 0; i < size; i++) {
                sublist.add(queue.peek().val);
                queue.addAll(queue.poll().children);
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
