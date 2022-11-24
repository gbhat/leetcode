//https://leetcode.com/problems/perfect-squares/

// Recursive solution. Gives TLE.
public class PerfectSquares {
    public int numSquares(int n) {
        if (isSquare(n) || n == 1)
            return 1;

        int min = n;
        for(int i = 1; i < n; i++) {
            min = Math.min(min, numSquares(i) + numSquares(n - i));
        }
        return min;
    }

    private boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return sqrt - (int) sqrt == 0;
    }
}
