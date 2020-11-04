package dp.medium;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII_63 {

    // 11/04/2020
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length + 1, n = grid[0].length + 1;
        int[][] dp = new int[m][n];
        dp[0][1] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i-1][j-1] == 0 ? dp[i-1][j] + dp[i][j-1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }
}
