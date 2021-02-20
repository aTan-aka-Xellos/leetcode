package tree.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Not optimal because need to reverse the result at the end.
 */
public class BinaryTreePostorderTraversal_145 {




    // 07/04/2019
    public List<Integer> postorderTraversal_v2(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                list.add(node.val);
                if (node.left  != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
        }
        Stack<Integer> rev = new Stack<>();
        list.forEach(rev::push);
        list.clear();

        while (!rev.isEmpty()) list.add(rev.pop());
        return list;
    }

    // 02/19/2021
    public List<Integer> postorderTraversal_v1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    void traversal(TreeNode node, List<Integer> list) {
        if (node == null) return;

        traversal(node.left,  list);
        traversal(node.right, list);
        list.add(node.val);
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
