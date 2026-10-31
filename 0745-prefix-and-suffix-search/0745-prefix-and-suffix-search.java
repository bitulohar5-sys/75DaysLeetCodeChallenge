class WordFilter {

    class TrieNode {
        TrieNode[] children = new TrieNode[27];
        int index = -1;
    }

    TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {

                String key = word.substring(j) + "{" + word;

                insert(key, i);
            }
        }
    }

    private void insert(String key, int index) {

        TrieNode node = root;

        for (char ch : key.toCharArray()) {

            int pos = ch == '{' ? 26 : ch - 'a';

            if (node.children[pos] == null) {
                node.children[pos] = new TrieNode();
            }

            node = node.children[pos];
            node.index = index;
        }
    }

    public int f(String pref, String suff) {

        String key = suff + "{" + pref;

        TrieNode node = root;

        for (char ch : key.toCharArray()) {

            int pos = ch == '{' ? 26 : ch - 'a';

            if (node.children[pos] == null) {
                return -1;
            }

            node = node.children[pos];
        }

        return node.index;
    }
}
