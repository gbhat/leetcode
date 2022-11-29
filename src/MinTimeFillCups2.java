//https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/

import java.util.Comparator;
import java.util.PriorityQueue;

/*
From: https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups/discuss/2261394/JavaC%2B%2BPython-max(max(A)-(sum(A)-%2B-1)-2)
Explanation
It's a brain-teaser.

Necessary conditions (lower bound)

    res >= max(A)
    Because each time,
    one type can reduce at most 1 cup,
    so the final result is bigger or equal to max(A)

    res >= ceil(sum(A) / 2)
    Because each time,
    we can fill up to 2 cups,
    so the final result is bigger or equal to ceil(sum(A) / 2)

Sufficient considtion (realizeable)
One strategy is to greedily fill up 2 cups with different types of water.
Each step, we pick the 2 types with the most number of cups, until there is only one kind.

Conclusion
The lower bound is realizable,
so it's proved as the minimum steps.

Complexity
Time O(n)
Space O(1)
 */

public class MinTimeFillCups2 {
    public int fillCups(int[] A) {
        int mx = 0, sum = 0;
        for(int a: A) {
            mx = Math.max(a, mx);
            sum += a;
        }
        return Math.max(mx, (sum + 1) / 2);
    }
}