package heap.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements_347 {

    // 01/25/2021
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> map = new HashMap<>();
        int[] top = new int[k];

        for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) pq.offer(entry);
        for (int i = 0; i < k; i++) top[i] = pq.poll().getKey();

        return top;
    }
}
