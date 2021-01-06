package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum_1 {

    // 01/05/2021
    public int[] twoSum_v2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    // 09/13/2018
    public static int[] twoSum(int[] nums, int target) {

        Integer first;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            first = map.get(target - nums[i]);
            if (first != null && first != i)
                return new int[]{first, i};

            map.put(nums[i], i);
        }
        return null;
    }


}
