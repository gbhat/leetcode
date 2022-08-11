//https://leetcode.com/problems/validate-binary-search-tree/


/*
    Validating only left and right values does not work. BELOW CODE DOES NOT WORK for input: [5,4,6,null,null,3,7]
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (root.right != null && root.right.val <= root.val)
            return false;
        if (root.left != null && root.left.val >= root.val)
            return false;

        return isValidBST(root.right) && isValidBST(root.left);
    }
 */

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        return root.val > min && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}
