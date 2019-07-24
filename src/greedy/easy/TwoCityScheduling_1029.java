package greedy.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-city-scheduling/submissions
 * Time complexity: O(N logN + N) = O(N logN)
 * Space complexity: O(1)
 */
public class TwoCityScheduling_1029 {

    /**
     * Execution time: ~40-50 ms
     * The issue is lambda
     */
    public int twoCitySchedCost(int[][] costs) {

        // This is too slow
        // Arrays.sort(costs, Comparator.comparingInt(a -> a[0] - a[1]));

        // sort by difference in the schedule between A and B
        Arrays.sort(costs, (a, b) -> (a[0] - a[1] - (b[0] - b[1])));

        int sum = 0;

        for (int i = 0; i < costs.length / 2; i++) {
            sum += costs[i][0];
            sum += costs[costs.length - 1 - i][1];
        }

        return sum;
    }

    /**
     * min(sum(A1+B2)) = min(sum(A1+A2-A2+B2)) = min(sum(A - (A2-B2)))
     * https://leetcode.com/problems/two-city-scheduling/discuss/285099
     * Execution time: 1 ms
     */
    public int _twoCitySchedCost(int[][] costs) {
        int[] diff = new int[costs.length];
        int sum = 0;
        for(int i=0; i<costs.length; i++) {
            diff[i] = costs[i][0] - costs[i][1];
            sum += costs[i][0];
        }
        Arrays.sort(diff);
        for(int i=diff.length/2; i<diff.length; i++) {
            sum -= diff[i];
        }
        return sum;

    }

}
