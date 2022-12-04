//https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char ch : arr)
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Objects.equals(map.get(a), map.get(b)) ? a - b : map.get(b) - map.get(a));
        for(char ch : arr)
            pq.offer(ch);
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
            sb.append(pq.poll());
        return sb.toString();
    }
}