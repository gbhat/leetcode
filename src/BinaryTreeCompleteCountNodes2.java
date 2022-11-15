//https://leetcode.com/problems/count-complete-tree-nodes/

public class BinaryTreeCompleteCountNodes2 {
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                        : (1 << h-1) + countNodes(root.left);
    }

    static class TreeNode {
        public int data;
        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
