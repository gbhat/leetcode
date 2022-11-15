//https://leetcode.com/problems/count-complete-tree-nodes/

public class BinaryTreeCompleteCountNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int totalLevel = 0;
        TreeNode node = root;
        while(node != null) {
            totalLevel++;
            node = node.left;
        }

        int fullCount = (int) Math.pow(2, totalLevel) - 1;      // If the tree was full what would be the count
        int less = countLess(root, totalLevel);                 // Count null nodes in the last level
        return fullCount - less;
    }

    private int countLess(TreeNode root, int level) {
        if (level == 0)
            return 0;
        if (root == null)
            return 1;

        int total = countLess(root.right, level - 1);
        total += countLess(root.left, level - 1);
        return total;
    }

    static class TreeNode {
        public int data;
        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
