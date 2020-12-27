package tree.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class DeleteNodesAndReturnForest_1110 {

    // 12/27/2020
    // - main issue - coding
    // - forgot to clean-up node links to children
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int val: to_delete) set.add(val);

        if (root != null) stack.add(root);
        if (!set.contains(root.val)) list.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            boolean isN = set.contains(node.val);

            if (node.left != null) {
                stack.push(node.left);
                if (set.contains(node.left.val)) node.left = null;
                else if (isN) list.add(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
                if (set.contains(node.right.val)) node.right = null;
                else if (isN) list.add(node.right);
            }
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
