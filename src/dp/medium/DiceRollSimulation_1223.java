package dp.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/dice-roll-simulation
 * Explained by Alex.
 *
 * Still wasn't able to finish implementation by myself
 * Used as reference:
 * https://leetcode.com/problems/dice-roll-simulation/discuss/800211/Iterative-DP-Solution-using-c%2B%2B
 *
 * Useful detailed examples of the combinations:
 * https://leetcode.com/problems/dice-roll-simulation/discuss/529294/Java-2d-DP-with-rolls-and-the-last-number
 *
 * 10/30/2020 current understanding is not full
 */
public class DiceRollSimulation_1223 {

    /**
     * i - number of rolls
     * j - dice value [1-6]
     * m - dice value [1-6] before the suffix of similar rolls, at index [i-k]
     * k - length of the suffix of the similar numbers for j dice value
     */
    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n + 1][7];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 6; j++) {
                for (int m = 1; m <= 6; m++) {
                    if (m == j) continue;
                    for (int k = 1; k <= rollMax[m-1] && i >= k; k++) {
                        dp[i][j] = (dp[i][j] + dp[i-k][m]) % 1000000007;
                    }
                }
            }
        }
        return dp[n][0];
    }

}
