package hashtable.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 * Weekly contest 218
 */
public class MaxNumberOfKSumPairs_1679 {

    // 12/07/2020
    public int maxOperations(int[] nums, int k) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int diff = k - num;
            if (!map.containsKey(diff)) continue;
            if (num == diff && map.get(diff) < 2) continue;
            if (map.get(diff) <= 0 || map.get(num) <= 0) continue;

            map.put(num,  map.get(num) - 1);
            map.put(diff, map.get(diff) - 1);
            count++;
        }

        return count;
    }
}
