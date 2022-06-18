//https://leetcode.com/problems/number-of-ways-to-select-buildings/

public class SelectBuildingWays {
    public long numberOfWays(String s) {
        long zero = 0, one = 0;
        long zeroOne = 0, oneZero = 0;
        long zeroOneZero = 0, oneZeroOne =0;
        for(char c : s.toCharArray()) {
            if (c == '0') {
                zero++;
                oneZero += one;
                zeroOneZero += zeroOne;
            } else {
                one++;
                zeroOne += zero;
                oneZeroOne += oneZero;
            }
        }
        return zeroOneZero + oneZeroOne;
    }
}

