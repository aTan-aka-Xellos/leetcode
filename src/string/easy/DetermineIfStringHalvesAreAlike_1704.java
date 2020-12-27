package string.easy;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 * Weekly Contest 221
 */
public class DetermineIfStringHalvesAreAlike_1704 {

    // 12/27/2020
    public boolean halvesAreAlike(String s) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        int count = 0, n = s.length();
        for (int i = 0; i < n / 2; i++) {
            for (char c: vowels) {
                if (s.charAt(i) == c) count++;
                if (s.charAt(n - i - 1) == c) count--;
            }
        }

        return count == 0;
    }

}
