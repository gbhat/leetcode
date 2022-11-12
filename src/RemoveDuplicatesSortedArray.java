//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int end = 0;
        int i;
        for(i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1])
                nums[end++] = nums[i];
        }
        nums[end++] = nums[i];

        return end;
    }
}