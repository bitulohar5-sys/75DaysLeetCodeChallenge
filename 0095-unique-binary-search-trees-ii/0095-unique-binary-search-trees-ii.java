class Solution {

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every value as root
        for (int root = start; root <= end; root++) {

            List<TreeNode> leftTrees = build(start, root - 1);
            List<TreeNode> rightTrees = build(root + 1, end);

            // Combine every left tree with every right tree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode node = new TreeNode(root);

                    node.left = left;
                    node.right = right;

                    result.add(node);
                }
            }
        }

        return result;
    }
}