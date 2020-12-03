package bfs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow_515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);

        while (!q.isEmpty()) {

            int count = q.size();
            int max = Integer.MIN_VALUE;

            while (count-- > 0) {
                TreeNode node = q.poll();
                if (node.left  != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

                max = Math.max(max, node.val);
            }
            list.add(max);
        }
        return list;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
