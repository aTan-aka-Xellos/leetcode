package greedy.easy;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks/
 */
public class MinimumCostToConnectSticks_1167 {

    // 11/28/2020
    public int connectSticks(int[] sticks) {

        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s: sticks) pq.add(s);

        while (pq.size() > 1) {
            int x = pq.poll();

            if (!pq.isEmpty()) {
                x += pq.poll();
                sum += x;
            }
            pq.add(x);
        }
        return sum;
    }

}
