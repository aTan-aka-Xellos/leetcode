package arrays.easy;

/**
 *
 */
public class MaximumAverageSubarrayI_643 {

    // 11/15/2020
    public double findMaxAverage_v2(int[] nums, int k) {
        double max = Integer.MIN_VALUE, sum = 0;
        int L = 0, R = 0;
        while (R < nums.length) {
            sum += nums[R++];
            if (R - L >= k) {
                max = Math.max(max, sum);
                sum -= nums[L++];
            }
        }
        return max / k;
    }

    // 11/15/2020
    public double findMaxAverage_v1(int[] nums, int k) {
        double max, sum = 0;

        for (int i = 0; i < k; i++) sum += nums[i];
        max = sum;

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max / k;
    }
}
