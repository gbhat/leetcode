//https://leetcode.com/problems/unique-number-of-occurrences/

import java.util.Arrays;

public class UniqueNumberOfOccurrences2 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] lookup= new int[2002];
        for(int n : arr)
            lookup[n + 1000]++;
        Arrays.sort(lookup);
        for(int i = 0; i < 2001; i++)
            if (lookup[i] != 0 && lookup[i] == lookup[i + 1])
                return false;
        return true;
    }
}
