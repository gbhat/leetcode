//https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.*;

public class BinaryTreeRightView {
    int maxLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        maxLevel = -1;
        List<Integer> result = new LinkedList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode root, List<Integer> result, int level) {
        if (root == null)
            return;

        if (level > maxLevel) {
            maxLevel = level;
            result.add(root.val);
        }

        rightView(root.right, result, level + 1);
        rightView(root.left, result, level + 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
