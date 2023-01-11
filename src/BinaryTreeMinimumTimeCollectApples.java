//https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

import java.util.*;

public class BinaryTreeMinimumTimeCollectApples {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], value -> new LinkedList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], value -> new LinkedList<>()).add(edge[0]);
        }
        return dfs(map, 0, -1, hasApple);
    }

    private int dfs(Map<Integer, List<Integer>> map, int node, int parent, List<Boolean> hasApple) {
        if (!map.containsKey(node))
            return 0;
        int total = 0;
        for(int child : map.get(node)) {
            if (child == parent)
                continue;
            int childTime = dfs(map, child, node, hasApple);
            if (childTime > 0 || hasApple.get(child))
                total += childTime + 2;
        }
        return total;
    }
}