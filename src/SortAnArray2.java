//https://leetcode.com/problems/sort-an-array/

//Quick Sort
public class SortAnArray2 {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qsort(int[] nums, int low, int high) {
        if (low > high)
            return;

        int p = partition(nums, low, high);
        qsort(nums, low, p - 1);
        qsort(nums, p + 1, high);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }
}