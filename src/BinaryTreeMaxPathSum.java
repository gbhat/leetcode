//https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class BinaryTreeMaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        max = Math.max(max, root.val + left + right);
        return Math.max(root.val + Math.max(left, right), 0);
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
    }
}