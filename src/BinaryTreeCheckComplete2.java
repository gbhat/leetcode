//https://leetcode.com/problems/check-completeness-of-a-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

//From: https://leetcode.com/problems/check-completeness-of-a-binary-tree/solutions/205682/java-c-python-bfs-solution-and-dfs-soluiton
public class BinaryTreeCheckComplete2 {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.peek() != null) {
            TreeNode next = queue.poll();
            queue.offer(next.left);
            queue.offer(next.right);
        }

        while(!queue.isEmpty() && queue.peek() == null)
            queue.poll();

        return queue.isEmpty();
    }


    static class TreeNode {
        public int data;
        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}