package twopointers.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 * Time: N logN
 */
public class KDiffPairsInAnArray_532 {

    // Time: O(N logN)
    // Space: O(N) - sorting 'might' use additional memory, depends on the impl
    public int findPairs(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        Arrays.sort(nums);

        while (right < nums.length && left < nums.length) {
            if (left == right || nums[right] - nums[left] < k) right++;
            else if (nums[right] - nums[left] > k) left++;
            else if (nums[right] - nums[left] == k) {
                count++;
                left++;
                while (left < nums.length && nums[left] == nums[left - 1]) left++;
            }
        }
        return count;
    }

    // Time: O(2N)
    // Space: O(N)
    public int _findPairs(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int key : freq.keySet()) {
            if (k > 0  && freq.containsKey(key + k))     result++;
            if (k == 0 && freq.getOrDefault(key, 0) > 1) result++;
        }
        return result;
    }
}
