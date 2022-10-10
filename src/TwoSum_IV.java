//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

import java.util.*;

// Uses O(n) space. Does not make use of the fact that it is a BST
public class TwoSum_IV {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return search(root, k, set);
    }

    private boolean search(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;

        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return search(root.left, k, set) || search(root.right, k, set);
    }

    class TreeNode {
        public int val;
        TreeNode left, right;
    }
}
