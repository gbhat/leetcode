//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrder {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        traverse(map, root, 0, 0);

        for(Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            Map<Integer, List<Integer>> map2 = entry.getValue();
            for(Map.Entry<Integer, List<Integer>> entry2 : map2.entrySet()) {
                Collections.sort(entry2.getValue());
            }
        }
        return map.values().stream().map(t -> t.values().stream().flatMap(s -> s.stream()).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private void traverse(TreeMap<Integer, TreeMap<Integer, List<Integer>>> map, TreeNode root, int order, int height) {
        if (root == null)
            return;

        if(map.containsKey(order)) {
            if (map.get(order).containsKey(height))
                map.get(order).get(height).add(root.val);
            else {
                List<Integer> list = new LinkedList<>();
                list.add(root.val);
                map.get(order).put(height, list);
            }
        }
        else {
            List<Integer> list = new LinkedList<>();
            list.add(root.val);
            TreeMap<Integer, List<Integer>> map2 = new TreeMap<>();
            map2.put(height, list);
            map.put(order, map2);
        }
        traverse(map, root.right, order + 1, height + 1);
        traverse(map, root.left, order - 1, height + 1);
    }

    static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}