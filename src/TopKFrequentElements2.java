//https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

public class TopKFrequentElements2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){ map.put(num, map.getOrDefault(num, 0) + 1); }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));       //Comparator uses the frequency from Map
        for(int key : map.keySet()){ heap.add(key); }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }

        return result;
    }
}