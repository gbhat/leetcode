//https://leetcode.com/problems/sort-an-array/

// Merge Sort
public class SortAnArray3 {
    public int[] sortArray(int[] nums) {
        msort(nums, 0, nums.length - 1);
        return nums;
    }

    private void msort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        msort(nums, low, mid);
        msort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int l = low;
        int m = mid + 1;
        int idx = 0;
        while (l <= mid && m <= high) {
            if (nums[l] < nums[m])
                tmp[idx++] = nums[l++];
            else
                tmp[idx++] = nums[m++];
        }
        if (m > high)
            System.arraycopy(nums, l, tmp, idx, mid - l + 1);
        if (l > mid)
            System.arraycopy(nums, m, tmp, idx, high - m + 1);

        System.arraycopy(tmp, 0, nums, low, high - low + 1);
    }
}