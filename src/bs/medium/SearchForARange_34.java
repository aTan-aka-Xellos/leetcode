package bs.medium;

public class SearchForARange_34 {

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
