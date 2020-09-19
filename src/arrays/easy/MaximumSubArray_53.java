package arrays.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubArray_53 {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum  = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

}
