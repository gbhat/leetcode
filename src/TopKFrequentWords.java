//https://leetcode.com/problems/top-k-frequent-words/

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> freqMap = new TreeMap<>();
        for(String word : words)
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);

        TreeMap<Integer, List<String>> revMap = new TreeMap<>(Comparator.reverseOrder());
        for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            revMap.putIfAbsent(entry.getValue(), new ArrayList<String>());
            revMap.get(entry.getValue()).add(entry.getKey());
        }


        List<String> result = new LinkedList<>();
        int top = revMap.firstKey();
        int count = 0;
        while(count < k && top > 0) {
            if (!revMap.containsKey(top)) {
                top--;
                continue;
            }
            List<String> res = revMap.get(top);
            for(int i = 0;i < res.size() && count < k; i++, count++)
                result.add(res.get(i));
            top--;
        }

        return result;
    }
}
