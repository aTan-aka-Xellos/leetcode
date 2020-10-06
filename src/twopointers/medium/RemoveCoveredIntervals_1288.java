package twopointers.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/remove-covered-intervals/
 */
public class RemoveCoveredIntervals_1288 {

    // the sorting by right size is not correct - because of it, need to set left interval to -1
    // the correct sorting is by the left side

    public int removeCoveredIntervals(int[][] intervals) {
        //Arrays.sort(intervals, (a, b) -> (a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]));
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(a -> a[1]).thenComparingInt(a -> -a[0]));
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][0] >= intervals[i][0]) {
                    intervals[j][0] = -1;
                    count++;
                }
            }
        }
        return intervals.length - count;
    }
}
