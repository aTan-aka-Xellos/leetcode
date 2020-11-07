package dp.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/knight-dialer/
 */
public class KnightDialer_935 {

    // 11/06/2020
    public int knightDialer(int n) {
        int M = 1_000_000_007;
        int[][] m = {{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int idx: m[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][idx]) % M;
                }
            }
        }
        return Arrays.stream(dp[n - 1]).reduce(0, (acc, val) -> (acc + val) % M);
    }
}
