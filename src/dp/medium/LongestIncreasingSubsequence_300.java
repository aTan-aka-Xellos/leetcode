package dp.medium;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence_300 {

    // 11/23/2020
    // Time: O(Nˆ2)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]++;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
