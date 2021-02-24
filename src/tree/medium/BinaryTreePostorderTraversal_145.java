package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal
 * A lot of pain to come up with approach
 */
public class BinaryTreePostorderTraversal_145 {

    // 02/24/2021
    // solution from @jinwu
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;

            list.addFirst(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        return list;
    }


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



    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal_v3(TreeNode root) {
        if (root != null) {
            postorderTraversal_v3(root.left);
            postorderTraversal_v3(root.right);
            list.add(root.val);
        }
        return list;
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
