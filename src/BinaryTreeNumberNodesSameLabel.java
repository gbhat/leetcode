//https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

import java.util.*;

public class BinaryTreeNumberNodesSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            // We need to add it both ways since it is defined as undirected graph. Input can be given as [parent, child] or [child, parent]
            map.computeIfAbsent(edge[0], value -> new LinkedList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], value -> new LinkedList<>()).add(edge[0]);
        }
        int[] result = new int[n];
        dfs(map, 0, -1, labels, result);
        return result;
    }

    private int[] dfs(Map<Integer, List<Integer>> map, int node, int parent, String labels, int[] result) {
        int[] count = new int[26];
        count[labels.charAt(node) - 'a']++;
        if (!map.containsKey(node)) {
            result[node] = 1;
            return count;
        }

        for(int child : map.get(node)) {
            if (child == parent)
                continue;
            int[] childCount = dfs(map, child, node, labels, result);
            for(int i = 0; i < childCount.length; i++)
                count[i] += childCount[i];
        }

        result[node] = count[labels.charAt(node) - 'a'];
        return count;
    }
}