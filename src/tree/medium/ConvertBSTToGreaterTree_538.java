package tree.medium;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * Need to repeat
 */
public class ConvertBSTToGreaterTree_538 {

    // 10/25/2020 (Zara shared screen first)
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convert(root, 0);
        return root;
    }

    int convert(TreeNode node, int sum) {
        if (node == null) return sum;

        node.val += convert(node.right, sum);
        return convert(node.left, node.val);
    }



    int convert_v2(TreeNode node, int sum) {
        if (node.right != null) sum = convert_v2(node.right, sum);
        node.val += sum;
        sum = node.val;
        if (node.left != null) sum = convert_v2(node.left, sum);
        return sum;
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
