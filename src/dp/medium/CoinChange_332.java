package dp.medium;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * Had some issues with corner cases and extra if conditions
 */
public class CoinChange_332 {

    // 10/30/2020
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i || dp[i - coin] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

}
