//https://leetcode.com/problems/remove-stones-to-minimize-the-total/

import java.util.PriorityQueue;

public class RemoveStonesMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int p : piles)
            pq.offer(p);
        for(int i = 0; i < k; i++) {
            int next = pq.poll();
            next -= next / 2;
            pq.offer(next);
        }

        return pq.stream().mapToInt(Integer::intValue).sum();
    }
}