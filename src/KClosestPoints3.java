//https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.*;

public class KClosestPoints3 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, (o1, o2) -> {
            double dist1 = Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]);
            double dist2 = Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1]);
            return Double.compare(dist2, dist1);
        });

        for(int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k)
                pq.poll();
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++)
            result[i] = pq.poll();

        return result;
    }
}