//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class RemoveDuplicatesSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int end = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1])
                nums[end++] = nums[i];
        }

        return end;
    }
}