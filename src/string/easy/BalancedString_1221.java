package string.easy;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings
 */
public class BalancedString_1221 {

    // 11/19/2020
    public int balancedStringSplit_v1(String s) {
        int L = 0, R = 0, sum = 0;

        for (char c: s.toCharArray()) {
            if (c == 'L') L++;
            else          R++;
            if (L == R) sum++;
        }
        return sum;
    }

    // 10/26/2019
    public static int balancedStringSplit_v2(String s) {
        int count = 0, l = 0, r = 0, idx = 0;

        while (idx < s.length()) {
            if (l == r && l > 0) {
                count++;
                l = 0;
                r = 0;
            } else if (s.charAt(idx) == 'L') {
                l++;
                idx++;
            } else if (s.charAt(idx) == 'R') {
                r++;
                idx++;
            }
        }
        return ++count;
    }
}
