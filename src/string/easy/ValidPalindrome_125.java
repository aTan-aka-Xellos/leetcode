package string.easy;

/**
 * https://leetcode.com/problems/valid-palindrome/submissions
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class ValidPalindrome_125 {

    public boolean isPalindrome(String s) {

        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {

            while (start < end && (getNum(s.charAt(start)) < 0 || getNum(s.charAt(start)) > 35)) start++;
            while (start < end && (getNum(s.charAt(end))   < 0 || getNum(s.charAt(end))   > 35)) end--;

            if (getNum(s.charAt(start)) != getNum(s.charAt(end))) return false;
        }
        return true;
    }

    private int getNum(char ch) {
        return Character.getNumericValue(ch);
    }
}
