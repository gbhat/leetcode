//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

import java.util.Arrays;

public class MinimumArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(b[0], a[0])); // Sort by x co-ordinate in decreasing order

        int shotAt= points[0][0];           // Shoot as left as possible
        int count = 1;
        for(int i = 1; i < points.length; i++) {
            if (points[i][1] >= shotAt)
                continue;
            count++;
            shotAt = points[i][0];
        }
        return count;
    }
}