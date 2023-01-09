//https://leetcode.com/problems/gas-station

public class GasStation2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalsum = 0;
        int start = 0;
        int sum = 0;
        for(int i = 0; i < gas.length; i++) {
            totalsum += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        return totalsum < 0 ? -1 : start;
    }
}