//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/


// This gives TLE. Is it because of DFS?
public class NearestExitFromMaze {
    int min = Integer.MAX_VALUE;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int x = entrance[0];
        int y = entrance[1];
        visited[x][y] = true;
        nearestExit(maze, visited, x, y, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void nearestExit(char[][] maze, boolean[][] visited, int x, int y, int steps) {
        if ((x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1) && !visited[x][y] && maze[x][y] != '+') {
            min = Math.min(steps, min);
        }

        visited[x][y] = true;
        for(int[] d : dirs) {
            int next_x = x + d[0];
            int next_y = y + d[1];
            if (isSafe(maze, visited, next_x, next_y)) {
                nearestExit(maze, visited, next_x, next_y, steps + 1);
            }
        }
        visited[x][y] = false;
    }

    private boolean isSafe(char[][] maze, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == '+' || visited[x][y])
            return false;
        return true;
    }
}