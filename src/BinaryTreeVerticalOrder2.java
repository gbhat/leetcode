//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrder2 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        traverse(map, root, 0, 0);

        return map.values().stream()                    // Stream values of the map, we dont need keys in the output
                .map(t -> t.values().stream()               // Take the values of the nested map, we dont need the keys of this map too
                        .flatMap(s -> s.stream().sorted())     // Flatten the Priority Qeueues to merge them. We use sorted because streaming PQ will not be in sorted order.
                        .collect(Collectors.toList()))         // Collect the flattened priority queues into list. This list contains values at different vertical orders
                .collect(Collectors.toList());              // Collect different vertical orders into another list.
    }

    private void traverse(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, TreeNode root, int order, int height) {
        if (root == null)
            return;

        if (!map.containsKey(order))
            map.put(order, new TreeMap<>());

        if (!map.get(order).containsKey(height))
            map.get(order).put(height, new PriorityQueue<>());

        map.get(order).get(height).offer(root.val);

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