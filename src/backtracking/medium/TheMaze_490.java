package backtracking.medium;

/**
 * https://leetcode.com/problems/the-maze/
 */
public class TheMaze_490 {

    // 11/19/2020
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        int x = start[0], y = start[1], x1, x2, y1, y2;

        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == -1) return false;
        if (dest[0] == x && dest[1] == y) return true;

        maze[x][y] = -1;
        x1 = x2 = x;
        y1 = y2 = y;

        while (x1 < maze.length    - 1 && maze[x1 + 1][y] != 1) x1++;
        while (y1 < maze[0].length - 1 && maze[x][y1 + 1] != 1) y1++;
        while (x2 > 0                  && maze[x2 - 1][y] != 1) x2--;
        while (y2 > 0                  && maze[x][y2 - 1] != 1) y2--;

        return hasPath(maze, new int[]{x1, y}, dest) || hasPath(maze, new int[]{x2, y}, dest) ||
               hasPath(maze, new int[]{x, y1}, dest) || hasPath(maze, new int[]{x, y2}, dest);
    }


    // 11/19/2020
    public boolean hasPath_v1(int[][] maze, int[] start, int[] dest) {
        int x = start[0], y = start[1];

        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) return false;
        if (maze[x][y] == -1) return false;

        if (dest[0] == x && dest[1] == y) return true;

        maze[x][y] = -1;
        int t = x;
        boolean res;

        while (t < maze.length - 1 && maze[t + 1][y] != 1) t++;
        res = hasPath(maze, new int[]{t, y}, dest);
        if (res) return true;

        t = x;
        while (t > 0 && maze[t - 1][y] != 1) t--;
        res = hasPath(maze, new int[]{t, y}, dest);
        if (res) return true;

        t = y;
        while (t < maze[0].length - 1 && maze[x][t + 1] != 1) t++;
        res = hasPath(maze, new int[]{x, t}, dest);
        if (res) return true;

        t = y;
        while (t > 0 && maze[x][t - 1] != 1) t--;
        res = hasPath(maze, new int[]{x, t}, dest);

        return res;
    }
}
