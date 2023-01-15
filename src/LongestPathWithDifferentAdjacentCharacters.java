//https://leetcode.com/problems/longest-path-with-different-adjacent-characters/

import java.util.*;

public class LongestPathWithDifferentAdjacentCharacters {
    int result;
    public int longestPath(int[] parent, String s) {
        ArrayList<Integer>[] children = new ArrayList[parent.length];
        for(int i = 0; i < parent.length; i++)
            children[i] = new ArrayList<>();
        for(int i = 1; i < parent.length; i++)
            children[parent[i]].add(i);

        dfs(children, s, 0);
        return result;
    }

    private int dfs(ArrayList<Integer>[] children, String s, int node) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int child : children[node]) {
            int cur = dfs(children, s, child);
            if (s.charAt(node) != s.charAt(child)) {
                queue.offer(cur);
            }
        }
        int big1 = queue.isEmpty() ? 0 : queue.poll();
        int big2 = queue.isEmpty() ? 0 : queue.poll();
        result = Math.max(result, big1 + big2 + 1);
        return big1 + 1;
    }
}