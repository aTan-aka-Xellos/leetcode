package bs.easy;

public class ClosestBinarySearchTreeValue_270 {

    public int closestValue(TreeNode root, double target) {
        int min = root.val;

        if (target > root.val && root.right != null) {
            int right = closestValue(root.right, target);
            if (Math.abs(target - right) < Math.abs(target - root.val)) min = right;
        }

        if (target < root.val && root.left != null) {
            int left = closestValue(root.left, target);
            if (Math.abs(target - left) < Math.abs(target - root.val)) min = left;
        }
        return min;
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
