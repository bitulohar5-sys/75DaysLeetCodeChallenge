from collections import deque

class Solution:
    def rightSideView(self, root):
        if not root:
            return []

        ans = []
        q = deque([root])

        while q:
            level_size = len(q)

            for i in range(level_size):
                node = q.popleft()

                # Last node of current level
                if i == level_size - 1:
                    ans.append(node.val)

                if node.left:
                    q.append(node.left)

                if node.right:
                    q.append(node.right)

        return ans