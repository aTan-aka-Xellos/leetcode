package arrays.medium;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 * Weekly Contest 221
 */
public class WhereWillTheBallFall_1706 {

    // 12/27/2020
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int col = i, row = 0;

            while (row < m) {
                if (col == 0     && grid[row][col] == -1) break; // wall
                if (col == n - 1 && grid[row][col] ==  1) break; // wall

                if (grid[row][col] ==  1 && grid[row][col + 1] !=  1) break; // V
                if (grid[row][col] == -1 && grid[row][col - 1] != -1) break; // V

                col += grid[row][col];
                row++;
            }

            if (row >= m) ans[i] = col;
            else          ans[i] = -1;
        }
        return ans;
    }

}
