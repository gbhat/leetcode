//https://leetcode.com/problems/count-good-nodes-in-binary-tree/

public class BinaryTreeGoodNodes {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode root, int maxVal) {
        if (root == null)
            return 0;

        if (root.val >= maxVal) {
            return 1 + goodNodes(root.left, root.val) + goodNodes(root.right, root.val);
        } else
            return goodNodes(root.left, maxVal) + goodNodes(root.right, maxVal);
    }

    class TreeNode {
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