//https://leetcode.com/problems/kth-missing-positive-number

public class KthMissing2 {
    public int findKthPositive(int[] arr, int k) {
        for(int a : arr) {
            if (a <= k)
                k++;
            else
                break;
        }
        return k;
    }
}
