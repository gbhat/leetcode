//https://leetcode.com/problems/path-sum-ii/

import java.util.*;

public class BinaryTreePathSum_II {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        pathSum(root, list, targetSum);
        return result;
    }

    private void pathSum(TreeNode root, List<Integer> list, int target) {
        if (root == null)
            return;

        list.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            result.add(new LinkedList<>(list));
        } else {
            pathSum(root.left, list, target - root.val);
            pathSum(root.right, list, target - root.val);
        }
        list.remove(list.size() - 1);
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
    }
}
