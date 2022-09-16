//https://leetcode.com/problems/find-original-array-from-doubled-array/

import java.util.*;

public class FindOrigArrayFromDoubledArray2 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        int[] result = new int[n/2];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.sort(changed);

        int i = 0;
        for(int num : changed){
            if(!queue.isEmpty() && queue.peek() == num)
                result[i++] = queue.poll() / 2;
            else
                queue.add(num * 2);
        }
        return queue.size() > 0 ? new int[0] : result;
    }
}