//https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

public class MaxValueAtIndex {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        int left = 0, right = maxSum, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (test(n, index, mid) <= maxSum)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    private long test(int n, int index, int mid) {
        int low = Math.max(mid - index, 0);
        long lowSum = (long)(mid + low) * (mid - low + 1) / 2;
        int high = Math.max(mid - ((n - 1) - index), 0);
        long highSum = (long)(mid + high) * (mid - high + 1) / 2;
        return lowSum + highSum - mid;
    }
}
