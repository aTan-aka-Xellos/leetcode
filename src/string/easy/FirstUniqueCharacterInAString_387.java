package string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Time complexity: O(2N) = O(N)
 */
public class FirstUniqueCharacterInAString_387 {

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) >= 0) return i;
        }
        return -1;
    }
}
