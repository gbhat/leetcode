//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

import java.util.*;

public class BinaryTreePseudoPalindrome2 {
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> set = new HashSet<>();
        return countPalindrome(root, set);
    }

    private int countPalindrome(TreeNode root, Set<Integer> set) {
        if (root == null)
            return 0;

        // If set already contains the value, remove it, otherwise add it to the set
        boolean contains = set.contains(root.val);
        if (contains)
            set.remove(root.val);
        else
            set.add(root.val);

        int ret;
        if (root.left == null && root.right == null) {
            ret = set.size() <= 1 ? 1 : 0;
        }
        else
            ret = countPalindrome(root.left, set) + countPalindrome(root.right, set);

        // Bring set back to the original state
        // If set was containing the value we would have removed it, we should add it back
        // If set did not have the value, we would have added it, we should remove it
        if (contains)
            set.add(root.val);
        else
            set.remove(root.val);
        return ret;
    }

    class TreeNode {
        public int val;
        TreeNode left, right;
    }
}
