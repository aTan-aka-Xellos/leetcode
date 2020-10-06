package tree.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode nodeL = stack.pop();
            TreeNode nodeR = stack.pop();

            if (nodeL == null  && nodeR == null) continue;
            if (nodeL == null || nodeR == null) return false;
            if (nodeL.val != nodeR.val) return false;

            stack.add(nodeL.right);
            stack.add(nodeR.left);
            stack.add(nodeL.left);
            stack.add(nodeR.right);
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
