//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class BinaryTreeConstructPreorderInorder {
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] pre, int[] in, int start, int end) {
        if (start > end)
            return null;
        if (start == end) {
            preIdx++;
            return new TreeNode(in[start]);
        }

        int val = pre[preIdx++];
        int idx = start;
        for(int i = start; i <= end; i++) {
            if (in[i] == val) {
                idx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(val);
        root.left = buildTree(pre, in, start, idx - 1);
        root.right = buildTree(pre, in, idx + 1, end);
        return root;
    }

    class TreeNode {
        public int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}