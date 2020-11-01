package others.medium;

/**
 * https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
 *
 * Biweekly 38
 */
public class CountSubstringsDifferByOneChar_1638 {

    // 11/01/2020
    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length() && j - i <= t.length(); j++) {
                count += count(s.substring(i, j), t);
            }
        }
        return count;
    }

    /**
     * Warning:
     * This code is garbage, was hard to decipher even the next day...
     *
     * Run all combinations.
     * For each index of the target string,
     * try substring and count diffs.
     *
     * If the diff > 1 or the string ended -> exit loop for the current substring for i-th index
     */
    private int count(String sub, String t) {
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            int diffCount = 0;

            for (int j = 0; j < sub.length() && diffCount < 2; j++) {
                if ((i + j) >= t.length()) {
                    diffCount = -1;
                    break;
                }
                if (t.charAt(i + j) != sub.charAt(j)) diffCount++;
            }
            if (diffCount == 1) count++;
        }
        return count;
    }
}
