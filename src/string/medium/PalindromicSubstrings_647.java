package string.medium;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * Access using array is 2-3x times faster than s.chatAt(i)
 * Probably due to:
 * - caching
 * - no if-else (inside charAt)
 * - System.arraycopy() is a native method
 */
public class PalindromicSubstrings_647 {

    // 10/28/2020
    public int countSubstrings(String s) {
        int count = 0;
        char[] a = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int offset = 0; offset < 2; offset++) {
                int l = i, r = i + offset;
                while (l >= 0 && r < a.length && a[l--] == a[r++]) {
                    count++;
                }
            }
        }
        return count;
    }

}
