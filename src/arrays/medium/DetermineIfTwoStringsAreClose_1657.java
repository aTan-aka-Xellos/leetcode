package arrays.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 *
 * Weekly contest 215
 */
public class DetermineIfTwoStringsAreClose_1657 {

    // 11/15/2020
    public boolean closeStrings(String w1, String w2) {
        if (w1.length() != w2.length()) return false;

        int n = w1.length();
        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i = 0; i < n; i++) {
            a1[w1.charAt(i) - 'a']++;
            a2[w2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == a2[i]) continue;
            if (a1[i] == 0 || a2[i] == 0) return false;
        }

        Arrays.sort(a1);
        Arrays.sort(a2);

        for (int i = a1.length - 1; i >= 0; i--) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }
}
