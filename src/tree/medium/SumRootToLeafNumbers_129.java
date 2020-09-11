package tree.medium;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers_129 {

    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }

    private int getSum(TreeNode node, int sum) {
        if (node == null) return 0;
        sum = 10 * sum + node.val;

        if (node.left == null && node.right == null) return sum;
        return getSum(node.left, sum) + getSum(node.right, sum);
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
