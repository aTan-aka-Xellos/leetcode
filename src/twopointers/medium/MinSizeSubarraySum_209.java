package twopointers.medium;

public class MinSizeSubarraySum_209 {

    public static int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = 0, min = Integer.MAX_VALUE, sum = 0;

        while (r < nums.length || sum >= s) {
            if (sum >= s) {
                min  = Math.min(min, r - l);
                sum -= nums[l++];
            }
            else
                sum += nums[r++];
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
