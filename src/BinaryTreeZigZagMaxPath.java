//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

//This gives Memory Limit Exceeded. Since we are using very long strings
public class BinaryTreeZigZagMaxPath {
    public int longestZigZag(TreeNode root) {
        return longest(root, "");
    }

    private int longest(TreeNode root, String pre) {
        int longest = pre.length();
        if (root.left != null) {
            if (pre.endsWith("L"))
                longest = Math.max(longest, longest(root.left, "L"));
            else
                longest = Math.max(longest, longest(root.left, pre + "L"));
        }
        if (root.right != null) {
            if (pre.endsWith("R"))
                longest = Math.max(longest, longest(root.right, "R"));
            else
                longest = Math.max(longest, longest(root.right, pre + "R"));
        }
        return longest;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
