package devideandconquer.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/closest-subsequence-sum/
 * Weekly Contest 227
 * Got hint from @Alex
 *
 * Used approach: Meet in the middle
 * https://www.geeksforgeeks.org/meet-in-the-middle
 *
 * Time complexity: O( 2ˆ(n/2) log 2ˆ(n/2) )   =>   O(n*2log(n/2))
 * Space complexity: O(2ˆ(n/2))
 */
public class ClosestSubsequenceSum_1755 {

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length, minDelta = Integer.MAX_VALUE;

        int[] A = new int[2 << (n / 2)];
        int[] B = new int[2 << (n + 1) / 2];

        gen(nums, 0,     n / 2, A);
        gen(nums, n / 2, n,     B);

        Arrays.sort(B);

        for (int candidate : A) {
            int delta = bs(B, goal - candidate);
            minDelta = Math.min(minDelta, delta);
        }
        return minDelta;
    }

    private int bs(int[] arr, int goal) {
        int L = 0, R = arr.length - 1; // both borders are inclusive

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (arr[mid] > goal) R = mid;
            else                 L = mid;
        }
        // either left eiter right border could be the closest
        return Math.min(Math.abs(goal - arr[L]), Math.abs(goal - arr[R]));
    }

    // Try each val from previously generated sums and add nums[curr]
    // Validation on "goal" could be added here
    private void gen(int[] nums, int start, int end, int[] fill) {
        int idx = 1;
        for (int curr = start; curr < end; curr++) {
            int last = idx;
            for (int i = 0; i < last; i++) {
                fill[idx++] = fill[i] + nums[curr];
            }
        }
    }
}
