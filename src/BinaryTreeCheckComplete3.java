//https://leetcode.com/problems/check-completeness-of-a-binary-tree/

//https://leetcode.com/problems/check-completeness-of-a-binary-tree/solutions/205682/java-c-python-bfs-solution-and-dfs-soluiton/comments/209403
public class BinaryTreeCheckComplete3 {

    public boolean isCompleteTree(TreeNode root) {
        int total = countNodes(root);
        return isCompleteTree(root, 0, total);
    }

    private boolean isCompleteTree(TreeNode root, int idx, int total) {
        if (root == null)
            return true;

        if (idx >= total)
            return false;

        return isCompleteTree(root.left, 2 * idx + 1, total) &&
                isCompleteTree(root.right, 2 * idx + 2, total);
    }

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static class TreeNode {
        public int data;
        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}