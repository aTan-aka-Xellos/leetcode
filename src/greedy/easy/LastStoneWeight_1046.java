package greedy.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/last-stone-weight
 * Time complexity: O(N * N logN) - not 100% sure
 * Space complexity: O(1)
 */
public class LastStoneWeight_1046 {

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
