package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary
 * Time complexity: O(1 + N * M) = O(N * K), where
 * 1 - order length
 * N - number of words
 * K - average length of words
 */
public class VerifyingAnAlienDictionary_953 {

    private Map<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrdered(words[i], words[i + 1]))
                return false;
        }

        return true;
    }

    private boolean isOrdered(String s1, String s2) {

        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (map.get(s1.charAt(i)) != map.get(s2.charAt(i)))
                return map.get(s1.charAt(i)) < map.get(s2.charAt(i));
        }

        return s1.length() <= s2.length();
    }
}
