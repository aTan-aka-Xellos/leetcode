package bfs.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands_200 {

    int[][] steps = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // recursive approach

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += markNeighbors(i, j, grid);
            }
        }
        return count;
    }

    int markNeighbors(int row, int col, char[][] grid) {
        if (!isValid(row, col, grid)) return 0;

        grid[row][col] = '#';
        for (int[] step : steps) {
            markNeighbors(row + step[0], col + step[1], grid);
        }
        return 1;
    }

    boolean isValid(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return false;
        return grid[row][col] == '1';
    }



    // iterative approach

    public int _numIslands(char[][] grid) {
        int count = 0;
        Stack<int[]> stack = new Stack<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    stack.add(new int[] {row, col});
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
            int row = pos[0], col = pos[1];
            grid[row][col] = '#';

            for (int[] step : steps) {
                if (isValid(row + step[0], col + step[1], grid)) {
                    stack.push(new int[] {row + step[0], col + step[1]});
                }
            }
        }
    }

}
