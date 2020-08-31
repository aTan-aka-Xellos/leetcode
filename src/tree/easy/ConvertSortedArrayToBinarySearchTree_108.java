package tree.easy;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree_108 {

    /*
     * copyOfRange is not optimal.
     * start, end parameters should be used
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = nums.length / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left  = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));

        return node;
    }


    // one line
    public TreeNode _sortedArrayToBST(int[] nums) {
        return nums.length != 0 ? new TreeNode(nums[nums.length / 2],
                _sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2)),
                _sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length)))
                : null;
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
