package tree.medium;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInBST_230 {

    int ans = -1;

    // 01/26/2021
    // Issues:
    // - confused when pass a counter
    // - handled the first root separately
    public int kthSmallest(TreeNode root, int k) {
        count(root, k, 0);
        return ans;
    }

    int count(TreeNode root, int k, int left) {
        if (ans != -1) return 0;
        if (root == null) return left;

        int count = count(root.left, k, left) + 1;
        if (ans == -1 && count == k) ans = root.val;
        return count(root.right, k, count);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
