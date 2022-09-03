//https://leetcode.com/problems/average-of-levels-in-binary-tree/

import java.util.*;

public class BinaryTreeLevelAverage {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new LinkedList<Double>();

        List<Double> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int total = 0;
            long sum = 0;
            long size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                sum += node.val;
                total++;
            }
            result.add((double) sum/total);
        }

        return result;
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
    }
}