//https://leetcode.com/problems/sum-root-to-leaf-numbers

public class BinaryTreeSumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return sumNum(root, 0);
    }

    private int sumNum(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }

        return sumNum(root.left, num * 10 + root.val) +
                sumNum(root.right, num * 10 + root.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
