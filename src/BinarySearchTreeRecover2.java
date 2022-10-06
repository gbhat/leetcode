//https://leetcode.com/problems/recover-binary-search-tree/

public class BinarySearchTreeRecover2 {
    int prevVal = Integer.MIN_VALUE;
    TreeNode tmp1, tmp2;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = tmp1.val;
        tmp1.val = tmp2.val;
        tmp2.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if(prevVal > root.val)
            tmp2 = root;
        if (tmp2 == null)
            tmp1 = root;
        prevVal = root.val;
        inorder(root.right);
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
    }}
