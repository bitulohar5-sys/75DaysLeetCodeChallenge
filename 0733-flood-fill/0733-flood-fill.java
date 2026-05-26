class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        // If the color is already same
        if (original == color) {
            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int original, int color) {

        int rows = image.length;
        int cols = image[0].length;

        // Boundary check
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return;
        }

        // Only fill original color cells
        if (image[r][c] != original) {
            return;
        }

        // Change color
        image[r][c] = color;

        // Visit 4 directions
        dfs(image, r + 1, c, original, color);
        dfs(image, r - 1, c, original, color);
        dfs(image, r, c + 1, original, color);
        dfs(image, r, c - 1, original, color);
    }
}