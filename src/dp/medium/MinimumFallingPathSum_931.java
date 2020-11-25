package dp.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class MinimumFallingPathSum_931 {

    // 11/25/2020
    public int minFallingPathSum(int[][] A) {
        int r = A.length + 1, c = A[0].length + 2;
        int[][] dp = new int[r][c];

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c - 1; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j+1]);
                dp[i][j] += A[i - 1][j - 1];
            }
            dp[i][0] = dp[i][c - 1] = Integer.MAX_VALUE;
        }
        return Arrays.stream(dp[r - 1]).min().orElse(-1);
    }

}
