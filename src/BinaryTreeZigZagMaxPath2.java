//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

public class BinaryTreeZigZagMaxPath2 {
    public int longestZigZag(TreeNode root) {
        return dfs(root, false, 0);
    }

    private int dfs(TreeNode root, boolean right, int len) {
        int res = len;
        if (root.left != null)
            res = Math.max(res, dfs(root.left, false, right ? len + 1 : 1));
        if (root.right != null)
            res = Math.max(res, dfs(root.right, true, right ? 1 : len + 1));
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
