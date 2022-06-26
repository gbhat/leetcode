// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

public class MaximumPointsCards {
    public int maxScore(int[] cardPoints, int k) {
        if (k > cardPoints.length)
            return 0;
        int sum = 0;
        int idx1 = 0;
        while(idx1 < k) {
            sum += cardPoints[idx1++];  //First compute sum from only left entries
        }
        idx1--;         // idx1 would have gone one index ahead. Bring it back to (k - 1)st index

        int maxSum = sum;       // Initialize maximum sum to current sum
        int idx2 = cardPoints.length - 1;
        while(idx1 >= 0) {
            sum -= cardPoints[idx1--];      //Subtract one left entry from the sum
            sum += cardPoints[idx2--];      //add one right entry to sum
            maxSum = Math.max(maxSum, sum); //keep track of maximum sum
        }

        return maxSum;
    }
}