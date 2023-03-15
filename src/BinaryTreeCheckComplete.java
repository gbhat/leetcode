//https://leetcode.com/problems/check-completeness-of-a-binary-tree/

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeCheckComplete {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;
        LinkedList<TreeNode> list = new LinkedList<>();

        list.add(root);

        while(!list.isEmpty()) {
            int size = list.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = list.poll();
                if (cur == null)
                    return checkOnlyNulls(list);
                list.offer(cur.left);
                list.offer(cur.right);
            }
        }
        return true;
    }

    private boolean checkOnlyNulls(List<TreeNode> list) {
        for(int i = 0; i < list.size(); i++)
            if (list.get(i) != null)
                return false;
        return true;
    }

    static class TreeNode {
        public int data;
        public TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
}
