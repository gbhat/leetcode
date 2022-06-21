// https://leetcode.com/problems/furthest-building-you-can-reach/

// Recursive solution not accepted. Check FarthestBuildingReach2.java
public class FarthestBuildingReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return farthest(heights, bricks, ladders, 0);
    }

    private int farthest(int[] heights, int bricks, int ladders, int cur) {
        if (cur == heights.length - 1)
            return cur;

        if (heights[cur] > heights[cur + 1])
            return farthest(heights, bricks, ladders, cur + 1);

        if (bricks <= 0 && ladders <= 0)
            return cur;


        int withLadder = cur;
        int withBricks = cur;
        if (bricks >= heights[cur + 1] - heights[cur])
            withBricks = farthest(heights, bricks - (heights[cur + 1] - heights[cur]), ladders, cur + 1);
        if (ladders > 0)
            withLadder = farthest(heights, bricks, ladders - 1, cur + 1);

        return Math.max(withLadder, withBricks);
    }
}