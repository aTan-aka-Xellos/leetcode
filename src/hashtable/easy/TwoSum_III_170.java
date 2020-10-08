package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 */
public class TwoSum_III_170 {

    /** Initialize your data structure here. */
    Map<Integer, Integer> cache = new HashMap<>();
    int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;


    /** Add the number to an internal data structure.. */
    public void add(int number) {
        cache.put(number, cache.getOrDefault(number, 0) + 1);
        min = Math.min(min, number);
        max = Math.max(max, number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if (value > max || value < min) return false;
        for (int val : cache.keySet()) {
            if (cache.containsKey(value - val)) {
                if (val + val != value || cache.get(val) > 1) return true;
            }
        }
        return false;
    }
}
