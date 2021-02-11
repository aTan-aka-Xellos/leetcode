package recursion.easy;

public class LongestUnivaluePath_687 {

    // 02/11/2021
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;

        int[] max = {0};
        getLength(root, max, root.val);
        return max[0];
    }

    int getLength(TreeNode root, int[] max, int parent) {
        if (root == null) return 0;

        int L = getLength(root.left,  max, root.val);
        int R = getLength(root.right, max, root.val);

        max[0] = Math.max(max[0], L + R);
        return root.val == parent ? Math.max(L, R) + 1 : 0;
    }

    // 02/11/2021
    public int longestUnivaluePath_v1(TreeNode root) {
        int[] max = {0};
        getLength(root, max);
        return max[0];
    }

    int getLength(TreeNode root, int[] max) {
        if (root == null) return 0;

        int L = getLength(root.left, max);
        int R = getLength(root.right, max);

        // find length of the branch including current node
        int left = 0, right = 0;
        if (root.left != null  && root.left.val  == root.val) {
            left += (L + 1);
        }
        if (root.right != null && root.right.val == root.val) {
            right += (R + 1);
        }

        max[0] = Math.max(max[0], left + right);
        return Math.max(left, right);
    }


    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
