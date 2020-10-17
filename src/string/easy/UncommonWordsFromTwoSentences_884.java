package string.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences
 */
public class UncommonWordsFromTwoSentences_884 {

    public String[] uncommonFromSentences(String A, String B) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        for (String s: (A + " " + B).split(" ")) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry: count.entrySet()) {
            if (entry.getValue() == 1) ans.add(entry.getKey());
        }
        return ans.toArray(new String[0]);
    }
}
