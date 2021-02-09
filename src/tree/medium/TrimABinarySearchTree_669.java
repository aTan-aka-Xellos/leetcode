package tree.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * Was asked during the mock.
 * Had a lot of troubles with iterative approach.
 * Totally missed the step with finding new root.
 * Made a mistake by missing the loop - both before and inside of the loop for the stack.
 */
public class TrimABinarySearchTree_669 {

    // 02/09/2021
    public TreeNode trimBST(TreeNode root, int low, int high) {
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low)  root = root.right;
            if (root.val > high) root = root.left;
        }
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;

            while (node.left != null && node.left.val < low) node.left = node.left.right;
            stack.push(node.left);

            while (node.right != null && node.right.val > high) node.right =  node.right.left;
            stack.push(node.right);
        }
        return root;
    }

    // 02/09/2021
    public TreeNode trimBST_v1(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low)  return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        root.left  = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
