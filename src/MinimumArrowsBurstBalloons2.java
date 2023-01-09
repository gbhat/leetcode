//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

import java.util.Arrays;

public class MinimumArrowsBurstBalloons2 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));     // Sort by y co-ordinate
        int count = 1;
        int shootAt = points[0][1];         // Shoot as right as possible
        for(int[] p : points) {
            if (p[0] <= shootAt)
                continue;
            count++;
            shootAt = p[1];
        }
        return count;
    }
}