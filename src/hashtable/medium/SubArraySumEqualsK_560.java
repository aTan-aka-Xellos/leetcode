package hashtable.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubArraySumEqualsK_560 {

    public int subarraySum(int[] nums, int k) {
        int sum = 0, total = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);

        for (int num : nums) {
            sum += num;
            total += cache.getOrDefault(sum - k, 0);
            cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        }
        return total;
    }
}
