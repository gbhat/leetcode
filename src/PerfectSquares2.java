//https://leetcode.com/problems/perfect-squares/

import java.util.*;

// Recursive with memoization. Gives TLE for large inputs.
public class PerfectSquares2 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numSquares(int n) {
        if (isSquare(n) || n == 1)
            return 1;

        if (map.containsKey(n))
            return map.get(n);

        int min = n;
        for(int i = 1; i <= n / 2; i++) {
            min = Math.min(min, numSquares(i) + numSquares(n - i));
        }
        map.put(n, min);
        return min;
    }

    private boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return sqrt - (int) sqrt == 0;
    }
}
