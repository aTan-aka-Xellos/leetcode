package heap.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-words/
 */
public class TopKFrequentWords_692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) ->  a.getValue().compareTo(b.getValue()) != 0
                        ? -a.getValue().compareTo(b.getValue())
                        :  a.getKey().compareTo(b.getKey()));


        for (Map.Entry<String, Integer> e: map.entrySet()) {
            pq.offer(e);
        }

        while (!pq.isEmpty() && k-- > 0) {
            list.add(pq.poll().getKey());
        }

        return list;
    }

}
