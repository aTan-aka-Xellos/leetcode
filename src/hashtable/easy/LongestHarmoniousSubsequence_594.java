package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */
public class LongestHarmoniousSubsequence_594 {

    // 11/01/2020
    public int findLHS(int[] nums) {

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            int left  = map.getOrDefault(key - 1, 0);
            int right = map.getOrDefault(key + 1, 0);
            if (left > 0 || right > 0) sum = Math.max(sum, Math.max(left, right) + map.get(key));
        }

        return sum;
    }
}
