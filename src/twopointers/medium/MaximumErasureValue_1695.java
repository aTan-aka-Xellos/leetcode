package twopointers.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-erasure-value/
 * Weekly Contest 220
 */
public class MaximumErasureValue_1695 {

    // 12/20/2020
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int L = 0, R = 0, max = 0, sum = 0;

        while (R < nums.length) {
            while (set.contains(nums[R])) {
                set.remove(nums[L]);
                sum -= nums[L++];
            }

            set.add(nums[R]);
            sum += nums[R++];
            max = Math.max(max, sum);
        }

        return max;
    }

}
