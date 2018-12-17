package tree.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
