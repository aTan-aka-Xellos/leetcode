package recursion.easy;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST_938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;

        if (root != null) {
            if (root.val >= L && root.val <= R) sum += root.val;
            sum += rangeSumBST(root.left,  L, R);
            sum += rangeSumBST(root.right, L, R);
        }
        return sum;
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
