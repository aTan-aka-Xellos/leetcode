package tree.easy;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees_617 {

    // 07/01/2020 10/30/2020
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val  += t2.val;
        t1.left  = mergeTrees(t1.left,  t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
    }
}
