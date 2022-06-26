// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

public class MaximumPointsCards2 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for (int i = 0; i < k; i++) total += cardPoints[i]; // take k cards in the beginning
        int ans = total;
        for (int i = 0; i < k; i++) {
            total += cardPoints[n - i - 1] - cardPoints[k - i - 1]; // Discard card (k-i-1)th, take card (n-i-1)th
            ans = Math.max(ans, total);
        }
        return ans;
    }
}