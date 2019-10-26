package string.easy;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings
 */
public class BalancedString_1221 {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RRLRRLRLLLRL") == 2);
        System.out.println(balancedStringSplit("RLRRLLRLRL") == 4);
        System.out.println(balancedStringSplit("RLLLLRRRLR") == 3);
        System.out.println(balancedStringSplit("RLLRRRLLLR") == 4);
        System.out.println(balancedStringSplit("LLLLRRRR") == 1);
    }


    public static int balancedStringSplit(String s) {
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
