//https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);

        TreeMap<Integer, List<Integer>> map2 = new TreeMap<>(Comparator.reverseOrder());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map2.putIfAbsent(entry.getValue(), new LinkedList<>());
            map2.get(entry.getValue()).add(entry.getKey());
        }

        Map.Entry<Integer, List<Integer>> entry = map2.pollFirstEntry();
        int[] result = new int[k];
        int idx = 0;
        for(int i = 0; i < k && idx < k; i++) {
            for(int n : entry.getValue())
                result[idx++] = n;
            entry = map2.pollFirstEntry();
        }
        return result;
    }
}