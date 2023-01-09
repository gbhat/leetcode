//https://leetcode.com/problems/max-points-on-a-line/

import java.util.*;

public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        if (points.length < 2)
            return 1;
        int max = 2;
        for(int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < points.length; j++){
                if (i == j)
                    continue;
                double slope = ((double) (points[j][1] - points[i][1])) / (points[j][0] - points[i][0]);
                map.put(slope, map.getOrDefault(slope, 1) + 1);
            }
            max = Math.max(max, Collections.max(map.values()));
        }
        return max;
    }
}