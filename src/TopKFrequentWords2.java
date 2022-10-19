//https://leetcode.com/problems/top-k-frequent-words/

import java.util.*;

public class TopKFrequentWords2 {
    class Pair implements Comparable<Pair> {
        public String word;
        public int freq;
        public Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        public int compareTo(Pair other) {
            if (this.freq != other.freq)
                return other.freq - this.freq;
            return this.word.compareTo(other.word);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(Map.Entry<String, Integer> entry : map.entrySet())
            pq.add(new Pair(entry.getKey(), entry.getValue()));

        List<String> result = new LinkedList<>();
        for(int i = 0; i < k; i++)
            result.add(pq.poll().word);

        return result;
    }
}