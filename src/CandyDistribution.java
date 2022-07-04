//https://leetcode.com/problems/candy/

import java.util.*;

public class CandyDistribution {
    public int candy(int[] ratings) {
        int[] lookup = new int[ratings.length];
        Arrays.fill(lookup, 1);

        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                lookup[i] = lookup[i - 1] + 1;
        }

        for(int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                if (lookup[i] > lookup[i + 1])      // Do not reset the count if we set it in forward pass
                    continue;
                lookup[i] = lookup[i + 1] + 1;
            }
        }

        int total = 0;
        for(int l : lookup)
            total += l;
        return total;
    }
}
