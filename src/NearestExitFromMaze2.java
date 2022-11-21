//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/

import java.util.LinkedList;

// BFS
public class NearestExitFromMaze2 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int steps = 0;

        int x = entrance[0];
        int y = entrance[1];

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[x][y] = true;

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for(int i = 0; i < size; i++) {
                int[] next = queue.poll();
                x = next[0];
                y = next[1];

                for(int[] d : dirs) {
                    int next_x = x + d[0];
                    int next_y = y + d[1];

                    if (next_x < 0 || next_y < 0 || next_x >= maze.length || next_y >= maze[0].length || visited[next_x][next_y] || maze[next_x][next_y] == '+')
                        continue;

                    if (next_x == 0 || next_y == 0 || next_x == maze.length - 1 || next_y == maze[0].length - 1)
                        return steps;

                    queue.add(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                }
            }
        }

        return -1;
    }
}