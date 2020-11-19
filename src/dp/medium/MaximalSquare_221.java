package dp.medium;

/**
 * https://leetcode.com/problems/maximal-square/
 * See CountSquareSubmatricesWithAllOnes_1277
 */
public class MaximalSquare_221 {

    // 11/10/2020 - with checking discussions
    public int maximalSquare_v2(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length + 1, m = matrix[0].length + 1, max = 0;
        int[][] dp = new int[n][m];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i - 1][j - 1] == '0') continue;

                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }


    // 11/10/2020 - own solution
    public int maximalSquare_v1(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length + 1, m = matrix[0].length + 1, max = 0;
        int[][][] dp = new int[n][m][3];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i-1][j-1] == '0') continue;

                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
                dp[i][j][2] = Math.min(Math.min(dp[i][j][0], dp[i][j][1]), dp[i - 1][j - 1][2] + 1);
                max = Math.max(max, dp[i][j][2]);
            }
        }
        return max * max;
    }
}
