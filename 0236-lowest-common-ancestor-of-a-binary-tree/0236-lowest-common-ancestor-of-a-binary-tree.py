class Solution:
    def lowestCommonAncestor(self, root, p, q):
        
        # Base case
        if root is None or root == p or root == q:
            return root

        # Search left subtree
        left = self.lowestCommonAncestor(root.left, p, q)

        # Search right subtree
        right = self.lowestCommonAncestor(root.right, p, q)

        # If both sides return non-null, current node is LCA
        if left and right:
            return root

        # Return the non-null node
        return left if left else right