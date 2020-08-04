package string.easy;

/**
 * https://leetcode.com/problems/valid-palindrome/submissions
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class ValidPalindrome_125 {

    // 2020 year version
    public boolean isPalindrome(String s) {
        char[] arr = s.toLowerCase().toCharArray();

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(arr[i])) i++;
            while (i < j && !Character.isLetterOrDigit(arr[j])) j--;

            if (arr[i] != arr[j]) return false;
        }
        return true;
    }


    public boolean _isPalindrome(String s) {

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
