package tree.easy;

/**
 https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        TreeNode left = root.left;
        if (left != null && left.left == null && left.right == null) sum += left.val;

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
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
