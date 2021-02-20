package tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal_144 {

    // 02/17/2021
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }

    void traverse(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        traverse(node.left,  list);
        traverse(node.right, list);
    }


    // 02/17/2021
    public List<Integer> preorderTraversal_v1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node == null) continue;

            list.add(node.val);
            st.push(node.right);
            st.push(node.left);
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
