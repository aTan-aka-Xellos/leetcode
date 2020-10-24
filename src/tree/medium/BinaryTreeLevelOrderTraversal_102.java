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
        if (list.size() - 1 < level) list.add(new ArrayList<>());

        list.get(level).add(node.val);
        iterate(node.left,  level + 1);
        iterate(node.right, level + 1);
    }



    public List<List<Integer>> levelOrder_v2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.add(root);

        while(!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                result.get(result.size() - 1).add(node.val);

                if (node.left  != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
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
