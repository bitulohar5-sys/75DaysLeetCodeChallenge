class Solution:
    def isSameTree(self, p, q):
        if not p and not q:
            return True
        if not p or not q:
            return False
        return (p.val == q.val and
                self.isSameTree(p.left, q.left) and
                self.isSameTree(p.right, q.right))

    def isSubtree(self, root, subRoot):
        if not root:
            return False
        
        # Check if trees match at this node
        if self.isSameTree(root, subRoot):
            return True
        
        # Otherwise check left and right
        return (self.isSubtree(root.left, subRoot) or
                self.isSubtree(root.right, subRoot))