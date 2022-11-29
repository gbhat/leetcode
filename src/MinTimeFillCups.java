//https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinTimeFillCups {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.offer(amount[0]);
        pq.offer(amount[1]);
        pq.offer(amount[2]);
        int result = 0;
        while(pq.peek() != 0) {
            int next1 = pq.poll() - 1;
            int next2 = pq.poll() - 1;
            result++;
            pq.offer(next1);
            pq.offer(next2);
        }
        return result;
    }
}