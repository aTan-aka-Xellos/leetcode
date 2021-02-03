package bs.medium;

/**
 * https://leetcode.com/problems/missing-element-in-sorted-array/
 */
public class MissingElementInSortedArray_1060 {

    /**
     * 02/02/2021
     * Issues:
     * - defining exact relationship condition
     * - why < used instead of <=
     * Maybe it's because we need not the mid itself, but the missing number?
     *
     */
    public int missingElement(int[] nums, int k) {
        int L = 0, R = nums.length;

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (nums[mid] - mid - k < nums[0]) L = mid;
            else                               R = mid;
        }
        return nums[0] + L + k;
    }
}
