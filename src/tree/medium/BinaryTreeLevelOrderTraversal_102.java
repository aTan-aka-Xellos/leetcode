package tree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal_102 {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        iterate(root, 0);
        return list;
    }

    void iterate(TreeNode node, int level) {
        if (node == null) return;

        if (list.size() - 1 < level) {
            list.add(new ArrayList<Integer>());
        }
        list.get(level).add(node.val);
        iterate(node.left, level + 1);
        iterate(node.right, level + 1);
    }



    public List<List<Integer>> _levelOrder(TreeNode root) {
        List<List<Integer>> global = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            global.add(list);
            while(size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
        }
        return global;
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
