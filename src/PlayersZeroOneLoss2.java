//https://leetcode.com/problems/find-players-with-zero-or-one-losses/

import java.util.*;

public class PlayersZeroOneLoss2 {
    public List<List<Integer>> findWinners(int[][] matches){
        Map<Integer, Integer> lossMap = new TreeMap<>();
        for(int[] m : matches){
            lossMap.put(m[0], lossMap.getOrDefault(m[0], 0));
            lossMap.put(m[1], lossMap.getOrDefault(m[1], 0) + 1);
        }
        List<List<Integer>> r = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player : lossMap.keySet())
            if(lossMap.get(player) <= 1)
                r.get(lossMap.get(player)).add(player);
        return r;
    }
}