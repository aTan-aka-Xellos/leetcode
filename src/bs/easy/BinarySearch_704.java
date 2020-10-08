package bs.easy;

/**
 * https://leetcode.com/explore/learn/card/binary-search/138/background/971
 */
public class BinarySearch_704 {

    // new solution from 10/08/2020
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lo = 0, hi = nums.length, mid;

        while (hi - lo > 1) {
            mid = (hi + lo) >>> 1;
            if (nums[mid] <= target) lo = mid;
            else                    hi = mid;
        }
        return nums[lo] == target ? lo : -1;
    }

    // old solution from 12/07/2018
    public static int _search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, index;

        do {
            index = lo + (hi - lo) / 2;
            if (nums[index] == target) return index;

            if (nums[index] > target) hi = index - 1;
            else                      lo = index + 1;
        } while (lo <= hi);

        return -1;
    }

}
