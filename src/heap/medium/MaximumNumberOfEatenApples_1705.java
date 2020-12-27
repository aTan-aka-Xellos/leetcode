package heap.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-number-of-eaten-apples/
 * Weekly Contest 221
 */
public class MaximumNumberOfEatenApples_1705 {

    // 12/27/2020
    // main issues:
    // - coding and corner cases
    // - writing comparator
    public static int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // (a, b) -> a[1] - b[1]

        int count = 0, day = 0;

        while (!pq.isEmpty() || day < apples.length) {
            if (day < apples.length && apples[day] != 0) {
                pq.add(new int[] {apples[day], days[day] + day});
            }

            while (!pq.isEmpty() && pq.peek()[1] <= day) pq.poll(); // remove old bucket

            if (!pq.isEmpty()) {
                count++;
                pq.peek()[0]--;
                if (pq.peek()[0] == 0) pq.poll();
            }
            day++;
        }
        return count;
    }
}
