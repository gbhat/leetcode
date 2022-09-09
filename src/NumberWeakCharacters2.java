//https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

import java.util.Arrays;

// Sample input: [[7,7],[1,2],[9,7],[7,3],[3,10],[9,8],[8,10],[4,3],[1,5],[1,5]]
public class NumberWeakCharacters2 {
    public int numberOfWeakCharacters(int[][] props) {
        Arrays.sort(props, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
/*
         for(int[] p : props)
             System.out.print(Arrays.toString(p) + ", ");
         System.out.println();
*/
        int result = 0;
        int max = 0;
        for (int[] prop : props) {

            if (prop[1] < max) {
                result++;
            }
            max = Math.max(max, prop[1]);
        }
        return result;
    }
}
