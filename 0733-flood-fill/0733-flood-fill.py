class Solution:
    def floodFill(self, image, sr, sc, color):
        rows = len(image)
        cols = len(image[0])

        original = image[sr][sc]

        # If the starting pixel already has the target color
        if original == color:
            return image

        def dfs(r, c):
            # Check boundaries
            if r < 0 or r >= rows or c < 0 or c >= cols:
                return

            # Only fill cells with original color
            if image[r][c] != original:
                return

            # Change color
            image[r][c] = color

            # Visit 4 directions
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        dfs(sr, sc)

        return image