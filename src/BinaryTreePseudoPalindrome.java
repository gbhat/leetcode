//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

import java.util.*;

public class BinaryTreePseudoPalindrome {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        countPalindrome(root, map);
        return count;
    }

    private void countPalindrome(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null)
            return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null) {
            if (checkPalindrome(map))
                count++;
        } else {
            countPalindrome(root.left, map);
            countPalindrome(root.right, map);
        }
        map.put(root.val, map.get(root.val) - 1);
    }

    // Check if the map contains count which can form a Palindrome
    // If more than one odd number of count is there then we return false
    private boolean checkPalindrome(HashMap<Integer, Integer> map) {
        if (map.isEmpty())
            return false;

        boolean isOdd = false;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (isOdd)
                    return false;
                isOdd = true;
            }
        }
        return true;
    }

    class TreeNode {
        public int val;
        TreeNode left, right;
    }
}
