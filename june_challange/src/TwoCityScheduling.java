import java.util.Arrays;

/**
 * See TwoCityScheduling_1029.java
 */
public class TwoCityScheduling {

    public static int twoCitySchedCost(int[][] costs) {

        int[] diff = new int[costs.length];
        int sum = 0;
        for (int i = 0; i < costs.length; i++) {
            diff[i] = costs[i][0] - costs[i][1];
            sum += costs[i][0];
        }

        Arrays.sort(diff);

        for (int i = diff.length / 2; i < diff.length; i++) {
            sum -= diff[i];
        }

        return sum;
    }
}
