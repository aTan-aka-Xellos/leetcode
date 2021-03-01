package graph.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph_133 {

    // 03/01/2021
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node[] origin = new Node[101];
        Node[] clones = new Node[101];

        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            origin[curr.val] = curr;

            for (Node orig: curr.neighbors) {
                if (origin[orig.val] == null) q.offer(orig);
            }
        }

        for (int i = 1; i < origin.length && origin[i] != null; i++) {
            if (clones[i] == null) clones[i] = new Node();
            clones[i].val = origin[i].val;

            for (Node orig: origin[i].neighbors) {
                if (clones[orig.val] == null) clones[orig.val] = new Node();
                clones[i].neighbors.add(clones[orig.val]);
            }
        }
        return clones[1];
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
    }
}
