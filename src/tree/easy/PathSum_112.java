package tree.easy;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left,   sum - root.val) ||
                hasPathSum(root.right,  sum - root.val);
    }
    
    public class TreeNode {
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
