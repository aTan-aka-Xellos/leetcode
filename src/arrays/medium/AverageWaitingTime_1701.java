package arrays.medium;

/**
 * https://leetcode.com/problems/average-waiting-time/
 * Biweekly Contest 42
 */
public class AverageWaitingTime_1701 {

    // 12/27/2020
    public double averageWaitingTime(int[][] customers) {
        double sum = 0;
        int end = 0;

        for (int[] customer: customers) {
            end = Math.max(end, customer[0]) + customer[1];
            sum += (end - customer[0]);
        }
        return sum / customers.length;
    }

}
