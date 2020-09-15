package tree.medium;

/**
 * https://leetcode.com/problems/path-sum-iii/
 * TODO:
 * Need to solve again with recursion.
 * Shows it's understanding.
 */
public class PathSum_III_437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int count = 0;

        // search sum, counting current node value
        count += BFSChild(root, sum);

        // start recursion from child node, as if it's the beginning of the task
        count += pathSum(root.left,  sum);
        count += pathSum(root.right, sum);

        return count;
    }


    int BFSChild(TreeNode node, int sum) {
        if (node == null) return 0;
        int count = 0;

        sum -= node.val;
        if (sum == 0) count++;

        count += BFSChild(node.left,  sum);
        count += BFSChild(node.right, sum);
        return count;
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
