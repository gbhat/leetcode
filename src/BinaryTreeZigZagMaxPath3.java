//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

public class BinaryTreeZigZagMaxPath3 {
    public int longestZigZag(TreeNode root) {
        return dfs(root)[2];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{-1, -1, -1};
        int[] left = dfs(root.left), right = dfs(root.right);
        int res = Math.max(Math.max(left[1], right[0]) + 1, Math.max(left[2], right[2]));
        return new int[]{left[1] + 1, right[0] + 1, res};
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
