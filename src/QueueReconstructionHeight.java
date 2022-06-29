//https://leetcode.com/problems/queue-reconstruction-by-height/

import java.util.*;

public class QueueReconstructionHeight {
    public int[][] reconstructQueue(int[][] people) {
        //First sort the entire array in decreasing order of height but increasing order of position
        //i.e. If array elements are [h_i, k_i], order them in decreasing order of h_i and increasing order k_i
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);

        List<int[]> list = new LinkedList<>();
        for(int[] p : people){
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][]);
    }
}