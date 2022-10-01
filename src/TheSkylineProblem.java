//https://leetcode.com/problems/the-skyline-problem/

import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new LinkedList<>();
        for(int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }

        Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        List<List<Integer>> result = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int cur = 0;
        for(int[] h : heights) {
            if (h[1] < 0)
                pq.offer(-h[1]);
            else
                pq.remove(h[1]);
            int top = pq.peek();
            if (cur != top){
                result.add(List.of(h[0], top));
                cur = top;
            }
        }

        return result;
    }
}