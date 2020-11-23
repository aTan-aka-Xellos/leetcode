package twopointers.easy;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes_283 {

    // 11/23/2020
    public void moveZeroes(int[] nums) {
        int L = 0, R = 0;

        while (R < nums.length) {
            if (nums[R] != 0) nums[L++] = nums[R];
            R++;
        }
        while (L < nums.length)  nums[L++] = 0;
    }
}
