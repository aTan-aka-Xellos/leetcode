package bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Refactored after review by @yznovyak (by e-main)
 *
 * https://pastebin.com/Lchyz6aQ
 */
public class NumberOfIslands_200 {

    int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // 10/01/2020
    // recursive approach
    public int numIslands_v1(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs( char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') return;

        grid[r][c] = '#';
        for (int[] step : steps) {
            dfs(grid, r + step[0], c + step[1]);
        }
    }



    // 10/01/2020
    // iterative approach
    public int numIslands_v2(char[][] grid) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    queue.add(new int[] {r, c});
                    dfs(queue, grid);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(Queue<int[]> queue, char[][] grid) {
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];
            if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') continue;

            grid[r][c] = '#';
            for (int[] step : steps) {
                queue.add(new int[] {r + step[0], c + step[1]});
            }
        }
    }

}
