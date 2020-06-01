import java.util.Stack;

/**
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if (root != null)
            stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode temp = node.left;

            node.left = node.right;
            node.right = temp;

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }

    public TreeNode invertTree_recursion(TreeNode root) {
        if (root != null)
            exchange(root);
        return root;
    }

    void exchange(TreeNode node) {
        TreeNode temp = node.left;

        node.left = node.right;
        node.right = temp;

        if (node.left != null)
            exchange(node.left);
        if (node.right != null)
            exchange(node.right);
    }
    
    public class TreeNode {
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
