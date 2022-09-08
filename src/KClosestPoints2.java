//https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.Arrays;

// This solution sorts the entire array. See KClosestPoints3.java for better and optimal approach
public class KClosestPoints2 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (o1, o2) -> {
            double dist1 = Math.sqrt(o1[0] * o1[0] + o1[1] * o1[1]);
            double dist2 = Math.sqrt(o2[0] * o2[0] + o2[1] * o2[1]);
            return Double.compare(dist1, dist2);
        });

        return Arrays.copyOfRange(points, 0, k);
    }
}



