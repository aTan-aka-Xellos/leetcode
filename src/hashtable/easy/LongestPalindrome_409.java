package hashtable.easy;

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

}
