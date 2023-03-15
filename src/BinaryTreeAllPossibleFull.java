//https://leetcode.com/problems/all-possible-full-binary-trees/

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeAllPossibleFull {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new LinkedList<>();
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        n--;
        for(int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i);

            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    result.add(new TreeNode(0, l, r));
                }
            }
        }
        return result;

    }

    static class TreeNode {
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


