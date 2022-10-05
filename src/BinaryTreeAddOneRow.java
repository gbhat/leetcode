//https://leetcode.com/problems/add-one-row-to-tree/

public class BinaryTreeAddOneRow {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return addNewRow(root, val, depth, true);
    }

    private TreeNode addNewRow(TreeNode root, int val, int depth, boolean isLeft) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            if(isLeft)
                node.left = root;
            else
                node.right = root;
            return node;
        }

        if (root == null)
            return root;

        root.left = addNewRow(root.left, val, depth - 1, true);
        root.right = addNewRow(root.right, val, depth - 1, false);
        return root;
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}