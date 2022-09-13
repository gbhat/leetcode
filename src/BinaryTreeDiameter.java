//https://leetcode.com/problems/diameter-of-binary-tree/

public class BinaryTreeDiameter {
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia = 0;
        findDia(root);
        return maxDia;
    }

    private int findDia(TreeNode root) {
        if (root == null)
            return 0;
        int leftDia = findDia(root.left);
        int rightDia = findDia(root.right);
        maxDia = Math.max(maxDia, leftDia + rightDia);
        return 1 + Math.max(leftDia, rightDia);
    }

    class TreeNode {
        public int val;
        TreeNode left, right;
    }
}