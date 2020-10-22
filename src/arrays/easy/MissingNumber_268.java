package arrays.easy;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber_268 {


    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] != i && nums[i] != nums.length) swap(nums, i, nums[i]);
            else i++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    private void swap(int[] nums, int a, int b) {
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }

}
