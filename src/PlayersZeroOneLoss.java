//https://leetcode.com/problems/find-players-with-zero-or-one-losses/

import java.util.*;

public class PlayersZeroOneLoss {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> noLoss = new HashSet<>();
        HashSet<Integer> oneLoss = new HashSet<>();
        HashSet<Integer> manyLoss = new HashSet<>();

        for(int[] match : matches) {
            if (noLoss.contains(match[1])) {
                noLoss.remove(match[1]);
                oneLoss.add(match[1]);
            } else if (oneLoss.contains(match[1])) {
                oneLoss.remove(match[1]);
                manyLoss.add(match[1]);
            } else if (!manyLoss.contains(match[1]))
                oneLoss.add(match[1]);

            if (manyLoss.contains(match[0]) || oneLoss.contains(match[0])) {
            } else
                noLoss.add(match[0]);
        }

        List<Integer> list1 = new LinkedList<>(noLoss);
        List<Integer> list2 = new LinkedList<>(oneLoss);
        Collections.sort(list1);
        Collections.sort(list2);
        return List.of(list1, list2);
    }
}