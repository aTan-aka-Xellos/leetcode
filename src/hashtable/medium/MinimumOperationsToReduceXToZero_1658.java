package hashtable.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * Weekly context 215
 */
public class MinimumOperationsToReduceXToZero_1658 {

    // 11/15/2020 - not optimized
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] L = new int[n + 1];
        int[] R = new int[n + 1];

        for (int i = 1; i <= n; i++)     L[i]     = L[i - 1] + nums[i - 1];
        for (int i = n - 1; i >= 0; i--) R[n - i] = R[n - i - 1] + nums[i];

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <= n && L[i] <= x; i++) {
            map.put(x - L[i], i);
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n && R[i] <= x; i++) {
            if (map.containsKey(R[i])) {
                int idx = map.get(R[i]);
                if ((idx + i) > n) continue;
                min = Math.min(min, idx + i);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
