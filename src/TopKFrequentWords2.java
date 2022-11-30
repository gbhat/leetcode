//https://leetcode.com/problems/top-k-frequent-words/

import java.util.*;

public class TopKFrequentWords2 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String str : words)
            map.put(str, map.getOrDefault(str, 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(b) == map.get(a) ? a.compareTo(b) : map.get(b) - map.get(a));
        for(String str : map.keySet())
            pq.offer(str);

        List<String> result = new LinkedList<>();
        for(int i = 0; i < k; i++)
            result.add(pq.poll());

        return result;
    }
}