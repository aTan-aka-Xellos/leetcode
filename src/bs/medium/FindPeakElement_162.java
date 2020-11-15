package bs.medium;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement_162 {

    // 11/12/2020
    public int findPeakElement(int[] a) {
        int L = 0, R = a.length, mid = 0;
        while (R - L > 1) {
            mid = (L + R) >>> 1;
            if (a[mid - 1] < a[mid]) L = mid;
            else                     R = mid;
        }
        return L;
    }


    // 12/13/2018
    public static int findPeakElement_v1(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }
        return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
    }

}
