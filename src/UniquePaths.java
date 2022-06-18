//https://leetcode.com/problems/unique-paths/

// Recursive solution. Not accepted. Check UniquePaths2.java
public class UniquePaths {
    int count = 0;
    public int uniquePaths(int m, int n) {
        count = 0;
        countPaths(0, 0, m, n);
        return count;
    }

    private void countPaths(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            count++;
            return;
        }

        if (i + 1 < m)
            countPaths(i + 1, j, m, n);
        if (j + 1 < n)
            countPaths(i, j + 1, m, n);
    }
}
