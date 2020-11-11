package dp.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class NumberOfDiceRollsWithTargetSum_1155 {

    // 11/11/2020
    public int numRollsToTarget(int d, int f, int target) {
        int M = 1_000_000_007;
        int [][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int roll = 1; roll <= d; roll++) {
            for (int sum = 1; sum <= target; sum++) {
                if (sum > roll * f) continue;
                for (int dice = 1; dice <= f && dice <= sum; dice++) {
                    dp[roll][sum] += dp[roll - 1][sum - dice];
                    if (dp[roll][sum] >= M) dp[roll][sum] %= M;
                }
            }
        }
        return dp[d][target];
    }

    // 11/11/2020
    public int numRollsToTarget_v1(int d, int f, int target) {
        int M = 1_000_000_007;
        Map<Integer, Integer> res = new HashMap<Integer, Integer>(){{put(0, 1);}};

        for (int i = 1; i <= d; i++) {
            Map<Integer, Integer> dp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry: res.entrySet()) {
                for (int dice = 1; dice <= f; dice++) {
                    int sum = entry.getKey() + dice;                         // prev sum + rolled dice value
                    int count = dp.getOrDefault(sum, 0) + entry.getValue();  // total ways to get current 'sum'
                    dp.put(sum, count % M);
                }
            }
            res = dp;
        }
        return res.getOrDefault(target, 0);
    }

}
