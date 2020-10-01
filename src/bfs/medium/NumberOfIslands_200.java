package bfs.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands_200 {


    int[][] steps = {{1,0},{0,1},{-1,0},{0,-1}};

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += markNeighbors(i, j, grid);
            }
        }
        return count;
    }

    int markNeighbors(int i, int j, char[][] grid) {
        if (!isValid(i, j, grid)) return 0;

        grid[i][j] = '#';
        for (int[] step : steps) {
            markNeighbors(i + step[0], j + step[1], grid);
        }
        return 1;
    }


    boolean isValid(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return false;
        return grid[i][j] == '1';
    }


    //// iterative approach
    public int _numIslands(char[][] grid) {
        int count = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    stack.add(new int[]{i,j});
                    _markNeighbors(stack, grid);
                    count++;
                }
            }
        }
        return count;
    }


    void _markNeighbors(Stack<int[]> stack, char[][] grid) {
        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int i = pos[0], j = pos[1];
            grid[i][j] = '#';

            for (int[] step : steps) {
                if (isValid(i + step[0], j + step[1], grid)) {
                    stack.push(new int[]{i + step[0], j + step[1]});
                }
            }
        }
    }

}
