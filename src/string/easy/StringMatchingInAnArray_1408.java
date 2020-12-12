package string.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/
 */
public class StringMatchingInAnArray_1408 {

    // 12/11/2020
    // Brute-force, no issues
    // There are some more advanced algorithms possible
    // Time: O(Nˆ2)
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();

        for (String w1: words) {

            for (String w2: words) {
                if (w2.length() <= w1.length()) continue;

                if (w2.contains(w1)) {
                    list.add(w1);
                    break;
                }
            }

        }
        return list;
    }

}
