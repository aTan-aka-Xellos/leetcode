package dp.easy;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber_198 {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 3];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 3] = nums[i] + Math.max(dp[i], dp[i + 1]);
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }

}
