package twopointers.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    // 11/26/2020 a lot of errors
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        int[] pos = new int[128];
        Arrays.fill(pos, -1);

        int max = 0, start = -1;

        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, pos[ch[i]]);
            pos[ch[i]] = i;
            max = Math.max(max, i - start);
        }
        return max;
    }
}
