package dp.easy;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs_746 {

    int[] cache;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length + 1];
        return minCostClimbingStairs(cost, cost.length);
    }

    public int minCostClimbingStairs(int[] cost, int n) {
        if (n <  0) return 0;

        if (cache[n] == 0) {
            int self  = (n == cost.length) ? 0 : cost[n];
            int sum_1 = minCostClimbingStairs(cost, n - 1);
            int sum_2 = minCostClimbingStairs(cost, n - 2);
            cache[n]  = self + Math.min(sum_1, sum_2);
        }
        return cache[n];
    }

}
