//https://leetcode.com/problems/binary-tree-pruning/

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        return prune(root) ? root : null;
    }

    private boolean prune(TreeNode root) {
        if (root == null)
            return false;

        boolean hasOneLeft = prune(root.left);
        if (!hasOneLeft)
            root.left = null;
        boolean hasOneRight = prune(root.right);
        if (!hasOneRight)
            root.right = null;

        return root.val == 1 || hasOneLeft || hasOneRight;
    }

    class TreeNode {
        int val;
        TreeNode left, right;
    }
}