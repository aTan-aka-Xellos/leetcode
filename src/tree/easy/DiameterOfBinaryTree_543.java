package tree.easy;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree_543 {

    // 02/11/2021
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = {0};
        getDepth(root, max);
        return max[0];
    }

    int getDepth(TreeNode root, int[] max) {
        if (root == null) return 0;

        int L = getDepth(root.left, max);
        int R = getDepth(root.right, max);

        max[0] = Math.max(max[0], L + R);
        return Math.max(L, R) + 1;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }


}
