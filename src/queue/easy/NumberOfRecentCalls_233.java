package queue.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class NumberOfRecentCalls_233 {

    Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && t - queue.peek() > 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
