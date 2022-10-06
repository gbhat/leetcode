//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

import java.util.*;

public class BinaryTreeConstructPreorderInorder2 {
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++)
            inorderIndexMap.put(inorder[i], i);

        return buildTree(preorder, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode buildTree(int[] pre, int[] in, int start, int end, Map<Integer, Integer> inorderIndexMap) {
        if (start > end)
            return null;
        if (start == end) {
            preIdx++;
            return new TreeNode(in[start]);
        }

        int val = pre[preIdx++];
        int idx = inorderIndexMap.get(val);

        TreeNode root = new TreeNode(val);
        root.left = buildTree(pre, in, start, idx - 1, inorderIndexMap);
        root.right = buildTree(pre, in, idx + 1, end, inorderIndexMap);
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