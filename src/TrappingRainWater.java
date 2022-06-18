// https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lmax = 0, rmax = 0;

        int total = 0;

        while(left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= lmax)
                    lmax = height[left];
                else
                    total += lmax - height[left];
                left++;
            } else {
                if (height[right] >= lmax)
                    lmax = height[right];
                else
                    total += lmax - height[right];
                right--;
            }
        }
        return total;
    }
}
