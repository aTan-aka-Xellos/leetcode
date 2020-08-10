package arrays.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesInAnArray_422 {

    // [4,3,2,7,8,2,3,1]
    // if you ever come across a value that is positive after negating if you know you've seen it before
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int value : nums) {
            value = Math.abs(value);
            nums[value - 1] = -nums[value - 1];
            if (nums[value - 1] > 0) result.add(value);
        }
        return result;
    }
}
