package string.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Tried to solve as DP but failed.
 * The idea was to use dp[max_palindrome_string] for i-th char, but it doesn't work.
 * DP solution is O(Nˆ2)
 *
 * An O(N) solution is Manacher’s Algorithm:
 * https://web.archive.org/web/20181208031518/https://articles.leetcode.com/longest-palindromic-substring-part-ii/
 * https://algs4.cs.princeton.edu/53substring/Manacher.java.html
 */
public class LongestPalindromicSubstring_5 {

    // 11/03/2020
    int L = 0, R = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            getP(s, i, i);
            getP(s, i, i + 1);
        }
        return s.substring(L + 1, R);
    }


    private void getP(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        if (r - l > R - L) {
            L = l;
            R = r;
        }
    }


    public String longestPalindrome_v2(String s) {
        int L = 0, R = 0, l, r;

        for (int i = 0; i < s.length(); i++) {
            l = i; r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
            if (r - l > R - L) { L = l; R = r; }

            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { l--; r++; }
            if (r - l > R - L) { L = l; R = r; }
        }
        return s.substring(L + 1, R);
    }


    /*

    TC:

        "ababababababa"
        "bananas"
        "aa"
        "aaaa"
        "abba"
        "a"
        "aca"
        "aaa"
        "babad"
        "cbbd"
        "ac"
        "aaacc"
        "ccaaa"
        "abdba"
        "abdbaa"
        "aabdba"

     */
}
