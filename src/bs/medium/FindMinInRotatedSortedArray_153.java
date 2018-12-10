package bs.medium;

/**
 * Q: Why lo + 1, when hi = mid?
 * A: The Binary Search split the range into two different part:
 * [lo, mid]
 * [mid + 1, high]
 * therefore we change the next lo equals to mid + 1, or the high equals to mid.
 */
public class FindMinInRotatedSortedArray_153 {

    public static int findMin(int[] nums) {
        int mid, lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) lo = mid + 1;
            else                      hi = mid;
        }
        return nums[lo];
    }
}
