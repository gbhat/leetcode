//https://leetcode.com/problems/the-skyline-problem/

import java.util.*;

public class TheSkylineProblem2 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new LinkedList<>();
        for(int[] b : buildings) {
            heights.add(new int[]{b[0], b[2]});
            heights.add(new int[]{b[1], -b[2]});
        }

        Collections.sort(heights, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        List<List<Integer>> result = new LinkedList<>();

        //Priority Queue has an efficiency of O(n) for remove. Instead use a map
        //Map contains the height and their count. If count reaches 0 we remove it.
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(0, 1);
        int cur = 0;
        for(int[] h : heights) {
            if (h[1] > 0)
                map.put(h[1], map.getOrDefault(h[1], 0) + 1);
            else {
                int count = map.get(-h[1]) - 1;
                if (count == 0)
                    map.remove(-h[1]);
                else
                    map.put(-h[1], count);
            }
            int top = map.firstKey();
            if (cur != top){
                result.add(List.of(h[0], top));
                cur = top;
            }
        }

        return result;
    }
}