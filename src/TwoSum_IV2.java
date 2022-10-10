//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

public class TwoSum_IV2 {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }

    private boolean findTarget(TreeNode root, TreeNode node, int k) {
        if (node == null)
            return false;
        TreeNode other = search(root, k - node.val);
        if (other != null && other != node)
            return true;
        return findTarget(root, node.left, k) || findTarget(root, node.right, k);
    }

    private TreeNode search(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        return val > root.val ? search(root.right, val) : search(root.left, val);
    }

    class TreeNode {
        public int val;
        TreeNode left, right;
    }
}
