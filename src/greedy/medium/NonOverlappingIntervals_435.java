package greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 0, end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (end > interval[0]) count++;
            else end = interval[1];
        }
        return count;
    }

}
