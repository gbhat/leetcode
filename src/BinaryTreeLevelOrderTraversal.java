//https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();

        if (root == null)
            return result;

        nodeList.add(root);
        while(!nodeList.isEmpty()) {
            int size = nodeList.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = nodeList.removeFirst();
                list.add(node.val);
                if (node.left != null)
                    nodeList.addLast(node.left);
                if (node.right != null)
                    nodeList.addLast(node.right);
            }
            result.add(list);
        }
        return result;
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;
    }
}
