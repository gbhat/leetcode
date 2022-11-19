//https://leetcode.com/problems/rectangle-area/

public class OverlappingRectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        int l = Math.max(ax1, bx1);
        int r = Math.min(ax2, bx2);
        int t = Math.min(ay2, by2);
        int b = Math.max(ay1, by1);

        int overlapWidth = Math.max(r - l, 0);      // Needed when there is no overlap. Example input: -2, -2, 2, 2, 3, 3, 4, 4
        int overlapHeight = Math.max(t - b, 0);

        return area1 + area2 - overlapWidth * overlapHeight;
    }
}
