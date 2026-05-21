class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    // Build Trie
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = buildTrie(words);

        List<String> result = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c,
                     TrieNode node, List<String> result) {

        // Boundary check
        if (r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length ||
            board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];

        TrieNode nextNode = node.children[ch - 'a'];

        // Character not present in Trie
        if (nextNode == null) {
            return;
        }

        // Word found
        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null; // avoid duplicates
        }

        // Mark visited
        board[r][c] = '#';

        // Explore 4 directions
        dfs(board, r + 1, c, nextNode, result);
        dfs(board, r - 1, c, nextNode, result);
        dfs(board, r, c + 1, nextNode, result);
        dfs(board, r, c - 1, nextNode, result);

        // Restore character
        board[r][c] = ch;
    }
}