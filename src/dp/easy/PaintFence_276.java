package dp.easy;

/**
 * https://leetcode.com/problems/paint-fence/
 */
public class PaintFence_276 {

    public int numWays(int n, int k) {
        int[] dp = new int[n + 3];
        dp[1] = k;
        dp[2] = k * dp[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }
        return dp[n];
    }

}
