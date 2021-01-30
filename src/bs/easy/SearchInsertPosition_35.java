package bs.easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int L = 0, R = nums.length;

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (nums[mid] > target) R = mid;
            else                    L = mid;
        }
        return nums[L] == target ? L : L + 1;
    }
}
