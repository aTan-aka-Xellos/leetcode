# https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
class Solution:
    class TreeNode:
        def __init__(self, val=0, left=None, right=None):
            self.val = val
            self.left = left
            self.right = right

    def invertTree(self, root: TreeNode) -> TreeNode:

        stack = []
        if root is not None:
            stack.append(root)

        while (stack):
            node = stack.pop()
            temp = node.left
            node.left = node.right
            node.right = temp

            if node.left is not None:
                stack.append(node.left)

            if node.right is not None:
                stack.append(node.right)

        return root



    def invertTreeRec(self, root: TreeNode) -> TreeNode:
        if root is None:
            return root

        temp = root.left
        root.left = root.right
        root.right = temp

        self.invert(root.left)
        self.invert(root.right)
        return root
