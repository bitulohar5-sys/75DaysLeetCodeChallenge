class Solution {
    public String tree2str(TreeNode root) {

        if (root == null) {
            return "";
        }

        // If node is a leaf
        if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }

        // If left child is null
        if (root.left == null) {
            return root.val + "()(" + tree2str(root.right) + ")";
        }

        // If right child is null
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }

        // If both children exist
        return root.val + "(" + tree2str(root.left) + ")(" 
                         + tree2str(root.right) + ")";
    }
}