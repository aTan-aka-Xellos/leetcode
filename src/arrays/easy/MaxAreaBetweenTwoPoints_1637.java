package arrays.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 *
 * Biweekly 38
 */
public class MaxAreaBetweenTwoPoints_1637 {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int max = 0;

        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - points[i - 1][0]);
        }
        return max;
    }
}
