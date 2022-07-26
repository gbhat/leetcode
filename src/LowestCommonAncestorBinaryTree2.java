//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class LowestCommonAncestorBinaryTree2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return result;
    }

    private boolean lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;

        boolean left = lca(root.left, p, q);
        boolean right = lca(root.right, p, q);

        boolean cur = (root == p) || (root == q);

        if ((left && right) ||      // If two nodes exist on each side of the cur node
                (left && cur) || // If one node is on the left and other one is current node
                (right && cur) ) // If one node is on the right and other one is current node
            result = root;

        return left || right || cur;
    }
}