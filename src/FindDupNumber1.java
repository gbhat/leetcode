//https://leetcode.com/problems/find-the-duplicate-number/

public class FindDupNumber1 {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        int dup = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for(int n : nums)
                if (n <= mid)
                    cnt++;

            if (cnt > mid) {
                dup = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return dup;

    }
}

