package bs.medium;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class SearchForARange_34 {

    // 02/06/2021
    public int[] searchRange_v2(int[] nums, int target) {
        int[] ans = {-1,-1};
        if (nums.length == 0) return ans;

        int L = -1, R = nums.length - 1;
        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (nums[mid] >= target)  R = mid;
            else                      L = mid;
        }
        if (nums[R] == target) ans[0] = R;


        L = R; R = nums.length;
        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (nums[mid] > target) R = mid;
            else                    L = mid;
        }
        if (nums[L] == target) ans[1] = L;

        return ans;
    }


    // 12/12/2018
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int mid, lo = 0, hi = nums.length - 1;
        int start = -1, end = -1;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else                    hi = mid;
        }
        if (nums[lo] == target) start = lo;

        hi = nums.length - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2 + 1;
            if (nums[mid] > target) hi = mid - 1;
            else                    lo = mid;
        }
        if (nums[hi] == target) end = hi;

        return new int[]{start, end};
    }
}
