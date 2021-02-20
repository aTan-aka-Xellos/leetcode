package tree.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class BinaryTreeInorderTraversal_94 {

    // 02/17/2021
    public List<Integer> inorderTraversal_v2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    void traverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

    // 02/20/2021
    // problematic part, need repetition
    public List<Integer> inorderTraversal_v3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }


    // 12/17/2018
    public List<Integer> inorderTraversal_v1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode cursor = root;

        while (cursor != null || !deque.isEmpty()) {
            while (cursor != null) {
                deque.push(cursor);
                cursor = cursor.left;
            }
            cursor = deque.pop();
            list.add(cursor.val);
            cursor = cursor.right;
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
