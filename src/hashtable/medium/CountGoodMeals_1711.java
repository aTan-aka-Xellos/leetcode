package hashtable.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-good-meals/
 */
public class CountGoodMeals_1711 {

    // 01/04/2021
    // Issues:
    // - tried over-complicated approach with formulas and adding all numbers to the Map as first step
    // - forgot two-sum pattern with adding a number after the 'get'
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int d: deliciousness) {
            for (int i = 0, num = 1; i < 22; i++, num <<= 1) {
                count += map.getOrDefault(num - d, 0);
                count %= 1_000_000_007;
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        return count;
    }
}
