//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

public class BinarySearchTreeLCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    class TreeNode {
        public TreeNode left, right;
        public int val;
    }
}