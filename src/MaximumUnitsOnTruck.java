//https://leetcode.com/problems/maximum-units-on-a-truck/

import java.util.*;

public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;
        for(int[] box : boxTypes) {
            if (truckSize - box[0] >= 0) {
                truckSize -= box[0];
                totalUnits += box[0] * box[1];
            } else {
                totalUnits += truckSize * box[1];
                truckSize = 0;
            }
        }
        return totalUnits;
    }
}
