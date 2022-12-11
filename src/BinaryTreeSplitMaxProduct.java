//https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
public class BinaryTreeSplitMaxProduct {
    long total = 0, res = 0;
    public int maxProduct(TreeNode root) {
        total = sum(root);
        sum(root);
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    private long sum(TreeNode root) {
        if (root == null)
            return 0;
        long sum = root.val + sum(root.left) + sum(root.right);
        res = Math.max(res, sum * (total - sum));
        return sum;
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
    }
}