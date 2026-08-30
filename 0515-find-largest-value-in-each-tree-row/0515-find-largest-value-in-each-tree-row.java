class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        // If the tree is empty
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Process the tree level by level
        while (!queue.isEmpty()) {

            int size = queue.size();
            int max = Integer.MIN_VALUE;

            // Process all nodes in the current level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                max = Math.max(max, node.val);

                // Add left child
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Maximum value of this level
            result.add(max);
        }

        return result;
    }
}