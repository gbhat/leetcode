//https://leetcode.com/problems/binary-tree-pruning/

public class BinaryTreePruning2 {
    public TreeNode pruneTree(TreeNode root) {

        if (root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        return root.val == 0 && root.left == null && root.right == null ? null : root;
    }

    class TreeNode {
        int val;
        TreeNode left, right;
    }
}