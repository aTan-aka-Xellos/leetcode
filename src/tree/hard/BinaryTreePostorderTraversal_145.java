package tree.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Not optimal because need to reverse the result at the end.
 */
public class BinaryTreePostorderTraversal_145 {

    public List<Integer> postorderTraversal(TreeNode root) {

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


    public List<Integer> postorderTraversal_recursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
