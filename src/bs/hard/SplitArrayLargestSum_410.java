package bs.hard;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum_410 {

    // 02/10/2021
    // Had a similar issue to FindKClosestElements_658
    // Usual pattern didn't work
    // Spend too much time on indexes and canSplit
    public int splitArray(int[] nums, int m) {

        int L = 0, R = 0;
        for (int num: nums) {
            if (num > L) L = num;
            R += num;
        }

        while (L < R) {
            int mid = (L + R) >>> 1;
            if (canSplit(nums, m, mid))  R = mid;
            else                         L = mid + 1;
        }
        return L;
    }

    private boolean canSplit(int[] nums, int m, int size) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > size) {
                sum = num;
                m--;
            }
        }
        return m > 0;
    }
}
