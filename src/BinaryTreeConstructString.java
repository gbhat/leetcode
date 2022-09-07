//https://leetcode.com/problems/construct-string-from-binary-tree/

public class BinaryTreeConstructString {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildStr(sb, root);
        return sb.toString();
    }

    private void buildStr(StringBuilder sb, TreeNode root) {
        if (root == null)
            return;

        sb.append(root.val);
        if (root.left != null || root.right != null) {
            sb.append('(');
            buildStr(sb, root.left);
            sb.append(')');
        }
        if (root.right != null) {
            sb.append('(');
            buildStr(sb, root.right);
            sb.append(')');
        }
    }

    class TreeNode {
        public int val;
        TreeNode left, right;
    }
}