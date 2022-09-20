//https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.*;

// This solution sorts the entire array.
public class KClosestPoints {
    class Point {
        public int[] coord;
        public double dist;
        public Point(int[] coord) {
            this.coord = coord;
            dist = Math.sqrt(coord[0] * coord[0] + coord[1] * coord[1]);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        List<Point> list = new LinkedList<>();
        for(int[] p : points) {
            list.add(new Point(p));
        }

        Collections.sort(list, (o1, o2) -> Double.compare(o1.dist, o2.dist));

        for(Point p : list) {
            System.out.println(p.coord[0] + " " + p.coord[1] + " " + p.dist);
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++)
            result[i] = list.get(i).coord;

        return result;
    }
}

