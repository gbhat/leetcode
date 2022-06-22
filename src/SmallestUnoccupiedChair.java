//https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/

import java.util.*;

public class SmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetTime = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        // Stores the available freeSeats
        PriorityQueue<Integer> freeSeats = new PriorityQueue<>();
        for(int i = 0; i < times.length; i++)
            freeSeats.offer(i);

        // Stores the combination of departure and the seat taken
        PriorityQueue<int[]> depSeatPQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] time : times) {
            // If any departure is earlier or equal to current arrival,
            // remove them from depSeatPQ and add the seat taken to freeSeats
            while (!depSeatPQ.isEmpty() && depSeatPQ.peek()[0] <= time[0]) {
                int[] depSeat = depSeatPQ.poll();
                freeSeats.offer(depSeat[1]);
            }

            if (time[0] == targetTime)
                break;

            depSeatPQ.offer(new int[]{time[1], freeSeats.poll()});
        }

        return freeSeats.peek();
    }
}