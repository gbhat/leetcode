//https://leetcode.com/problems/reduce-array-size-to-the-half/

import java.util.*;

public class ReduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(map.values());

        int count = 0;
        int size = arr.length;
        while(size > arr.length / 2) {
            size -= pq.poll();
            count++;
        }

        return count;
    }
}