package string.medium;

/**
 * https://leetcode.com/problems/split-two-strings-to-make-palindrome/
 *
 * The idea:
 * - iterate until strings are symmetric
 * - if we are at the middle - return true (skipped in code)
 * - otherwise - check if either of their's non-symmetric middle is a palindrome
 *
 * Pay attention:
 * - need to test strings in both directions
 *
 * Explanation:
 * https://stackoverflow.com/questions/56254994/divide-two-strings-to-form-palindrome
 */
public class SplitTwoStringsToMakePalindrome_1616 {

    public boolean checkPalindromeFormation(String a, String b) {
        return test(a, b) || test(b, a);
    }

    boolean test(String a, String b) {
        int index, n = a.length();

        for (index = 0; index < n / 2; index++) {
            if (a.charAt(index) != b.charAt(n - index - 1)) break;
        }
        return isPalindrome(a.substring(index, n - index)) || isPalindrome(b.substring(index, n - index));
    }

    boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.toString().equals(sb.reverse().toString());
    }
}
