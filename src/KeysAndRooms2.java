//https://leetcode.com/problems/keys-and-rooms/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Using BFS
public class KeysAndRooms2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];

        queue.add(0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int room = queue.poll();
                visited[room] = true;
                for(int r : rooms.get(room)) {
                    if (!visited[r])
                        queue.offer(r);
                }
            }
        }

        for(boolean v : visited)
            if (!v)
                return false;
        return true;
    }
}