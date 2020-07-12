package combinatorics.easy;

import java.util.Arrays;

/**
 * Contest Weekly Contest 197 - 1
 * https://leetcode.com/problems/number-of-good-pairs/
 */
public class NumberOfGoodPairs_1512 {

    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int total = 0, local = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                local = local + 1;
            } else {
                total += sum (local);
                local = 0;
            }
        }
        return total + sum(local);
    }

    public static int sum(int number) {
        int res = 0;
        while (number > 0) {
            res += number;
            number--;
        }
        return res;
    }

}
