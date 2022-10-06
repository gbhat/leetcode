//https://leetcode.com/problems/recover-binary-search-tree/

import java.util.*;

// Uses O(n) space.
public class BinarySearchTreeRecover {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        inorder(root, list);
        TreeNode tmp1 = null, tmp2 = null;
        for(int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                if (tmp1 == null) {
                    tmp1 = list.get(i);
                    tmp2 = list.get(i + 1);
                } else
                    tmp2 = list.get(i + 1);
            }
        }
        int tmp = tmp1.val;
        tmp1.val = tmp2.val;
        tmp2.val = tmp;
    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
    }
}
