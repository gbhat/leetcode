//https://leetcode.com/problems/kth-missing-positive-number

public class KthMissing {
    public int findKthPositive(int[] arr, int k) {
        int last = 1;
        int cnt = 1;
        int i = 0;
        while(i < arr.length) {
            if (k == cnt && arr[i] != last) {
                return last;
            } else if (arr[i] == last) {
                last++;
                i++;
            } else {
                last++;
                cnt++;
            }
        }
        return last + (k - cnt);    // We have to count k-cnt numbers after last
    }
}
