package greedy.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/last-stone-weight
 */
public class LastStoneWeight_1046 {


    /**
     * Time complexity: O(N logN)
     * Iterate over N elements, offer into queue is logN
     */
    public int _lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) queue.add(stone);

        while (queue.size() > 1) {
            queue.offer(queue.poll() - queue.poll());
        }
        return queue.poll();
    }

    /**
     * Time complexity: O(N * N logN) - not 100% sure
     * Space complexity: O(1)
     */
    public int lastStoneWeight(int[] stones) {

        while (stones.length > 1) {
            int last = stones.length - 1;

            Arrays.sort(stones);
            int diff = stones[last] - stones[last - 1];

            if (diff == 0) {
                stones = Arrays.copyOfRange(stones, 0, last - 1);
            } else {
                stones[last - 1] = diff;
                stones = Arrays.copyOfRange(stones, 0, last);
            }
        }
        return stones.length == 0 ? 0 : stones[0];
    }

}
