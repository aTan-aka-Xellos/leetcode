package tree.medium;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoABinarySearchTree_701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val > root.val) root.right = insertIntoBST(root.right, val);
        else                root.left  = insertIntoBST(root.left,  val);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
