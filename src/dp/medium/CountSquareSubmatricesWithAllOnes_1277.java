package dp.medium;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * See MaximalSquare_221
 */
public class CountSquareSubmatricesWithAllOnes_1277 {

    // 11/19/2020
    public int countSquares_v2(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, sum = 0;
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == 0) continue;

                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                sum += dp[i][j];
            }
        }
        return sum;
    }

    // 11/18/2020
    public int countSquares_v1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length, sum = 0;
        int [][][] dp = new int[n+1][m+1][3];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == 0) continue;

                dp[i][j][0] += dp[i][j-1][0] + 1;
                dp[i][j][1] += dp[i-1][j][1] + 1;

                if (dp[i-1][j-1][2] > 0) {
                    int size = Math.min(dp[i][j][0], dp[i][j][1]);
                    dp[i][j][2] = Math.min(size, dp[i-1][j-1][2] + 1);
                } else {
                    dp[i][j][2] = 1;
                }
                sum += dp[i][j][2];
            }
        }
        return sum;
    }
}
