//https://leetcode.com/problems/keys-and-rooms/

import java.util.List;

//Using DFS
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visit(rooms, visited, 0);
        for(boolean v : visited)
            if (!v)
                return false;
        return true;
    }

    private void visit(List<List<Integer>> rooms, boolean[] visited, int room) {
        if (visited[room])
            return;
        visited[room] = true;
        for(int r : rooms.get(room)) {
            visit(rooms, visited, r);
        }
    }
}