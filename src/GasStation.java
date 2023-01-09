//https://leetcode.com/problems/gas-station

// This gives TLE
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;
        for(int g : gas)
            gasSum += g;

        for(int c : cost)
            costSum += c;

        if (gasSum < costSum)
            return -1;

        for(int i = 0; i < cost.length; i++) {
            if (cost[i] <= gas[i]) {
                if (checkRoundTrip(gas, cost, i))
                    return i;
            }
        }
        return -1;
    }

    private boolean checkRoundTrip(int[] gas, int[] cost, int idx) {
        int gasVal = 0;
        int i = idx;
        do {
            gasVal += gas[i] - cost[i];
            if (gasVal < 0)
                return false;
            i = (i + 1) % gas.length;
        } while(i != idx);
        return true;
    }
}