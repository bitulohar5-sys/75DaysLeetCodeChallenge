class Solution {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the values of the two incorrect nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left subtree
        inorder(root.left);

        // Check BST property
        if (prev != null && prev.val > root.val) {

            // First incorrect node
            if (first == null) {
                first = prev;
            }

            // Second incorrect node
            second = root;
        }

        // Update previous node
        prev = root;

        // Right subtree
        inorder(root.right);
    }
}