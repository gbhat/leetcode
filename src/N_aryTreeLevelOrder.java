//https://leetcode.com/problems/n-ary-tree-level-order-traversal/

import java.util.*;

public class N_aryTreeLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null)
            return result;

        LinkedList<Node> list = new LinkedList<>();
        list.add(root);

        while(!list.isEmpty()) {
            List<Integer> r = new LinkedList<>();
            int size = list.size();
            for(int i = 0; i < size; i++) {
                Node node = list.removeFirst();
                list.addAll(node.children);
                r.add(node.val);
            }
            result.add(r);
        }
        return result;
    }

    static class Node {
        public int val;
        public List<Node> children;
    }
}