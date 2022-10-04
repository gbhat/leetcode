//https://leetcode.com/problems/flip-equivalent-binary-trees/

public class BinaryTreesFlipEquivalent {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        return root1 == root2 || (root1.val == root2.val && (flipEquiv(root1.left, root2.left) || flipEquiv(root1.left, root2.right)) &&
                (flipEquiv(root1.right, root2.right) || flipEquiv(root1.right, root2.left)));
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
    }
}