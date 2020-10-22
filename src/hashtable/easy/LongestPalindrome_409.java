package hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int res = 0;

        for (char c : s.toCharArray()) {
            count[c]++;
            if (count[c] == 2) {
                res += 2;
                count[c] = 0;
            }
        }

        if (res < s.length()) res++;
        return res;
    }

    public int longestPalindrome_v2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int val: map.values()) {
            count += val - (val % 2);
        }

        return count + (count == s.length() ? 0 : 1);
    }
}
