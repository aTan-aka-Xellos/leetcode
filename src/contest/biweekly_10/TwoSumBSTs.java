package contest.biweekly_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/contest/biweekly-contest-10/problems/two-sum-bsts/
 */
public class TwoSumBSTs {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) return false;

        int[] arr = traverseTree(root1, target);

        for (int i = 0; i < arr.length; i++) {
            TreeNode node = root2;
            while(node != null) {
                if (arr[i] == node.val)
                    return true;
                else if (arr[i] > node.val) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
        return false;
    }


    private int[] traverseTree(TreeNode root, int target) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(target - node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
