//https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

import java.util.*;

// Fails for long inputs. Check NumberWeakCharacters2.java
// Sample input: [[7,7],[1,2],[9,7],[7,3],[3,10],[9,8],[8,10],[4,3],[1,5],[1,5]]
public class NumberWeakCharacters {
    public int numberOfWeakCharacters(int[][] prop) {
        Arrays.sort(prop, (a, b) -> a[0] - b[0]);

        int result = 0;
        for(int i = 0; i < prop.length - 1; i++) {
            for(int j = i + 1; j < prop.length; j++) {
                if (prop[i][0] < prop[j][0] && prop[i][1] < prop[j][1]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}