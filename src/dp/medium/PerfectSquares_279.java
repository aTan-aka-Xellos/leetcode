package dp.medium;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares_279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int rest = i - j * j;
                if (dp[i] == 0 || dp[rest] < dp[i]) dp[i] = dp[rest] + 1;
            }
        }
        return dp[n];
    }
}
