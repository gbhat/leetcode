//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

import java.util.*;

// This approach uses a LinkedList to match the path from root to the given nodes.
// Check LowestCommonAncestorBinaryTree2.java
public class LowestCommonAncestorBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        List<TreeNode> path1 = new LinkedList<>();
        path1.add(root);
        findPath(root, p, path1);
        List<TreeNode> path2 = new LinkedList<>();
        path2.add(root);
        findPath(root, q, path2);

        int prev = -1, cur = 0;
        while(cur < path1.size() && cur < path2.size()) {
            if (path1.get(cur).val != path2.get(cur).val)
                return path1.get(prev);
            prev = cur;
            cur++;
        }

        return prev == -1 ? null : path1.get(prev);

    }

    private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        if (root.val == p.val)
            return true;

        path.add(root.left);
        if (findPath(root.left, p, path))
            return true;
        path.remove(root.left);

        path.add(root.right);
        if (findPath(root.right, p, path))
            return true;
        path.remove(root.right);

        return false;
    }
}