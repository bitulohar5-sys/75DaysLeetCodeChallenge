# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def preorderTraversal(self, root):
        
        result = []

        def preorder(node):
            if not node:
                return
            
            # Root
            result.append(node.val)

            # Left
            preorder(node.left)

            # Right
            preorder(node.right)

        preorder(root)

        return result