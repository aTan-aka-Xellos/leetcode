package string.easy;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII_680 {

    // 11/20/2020
    public boolean validPalindrome(String s) {
        int n = s.length(), L = 0, R = n - 1;
        char[] a = s.toCharArray();

        while (L < R) {
            if (a[L] != a[R])
                return isPalindrome(a, L, R - 1) || isPalindrome(a, L + 1, R);
            L++; R--;
        }
        return true;
    }

    boolean isPalindrome(char[] a, int L, int R) {
        while (L < R) {
            if (a[L] != a[R]) return false;
            L++; R--;
        }
        return true;
    }

}
