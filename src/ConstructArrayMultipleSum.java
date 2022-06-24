//https://leetcode.com/problems/construct-target-array-with-multiple-sums/

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstructArrayMultipleSum {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long sum = 0;
        for(int t : target) {
            sum += t;
            pq.add(t);
        }

        while (true) {
            int a = pq.poll();
            sum -= a;
            if (a == 1 || sum == 1)
                return true;
            if (a < sum || sum == 0 || a % sum == 0)
                return false;
            a %= sum;
            sum += a;
            pq.add(a);
        }
    }
}