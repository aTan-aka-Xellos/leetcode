package string.medium;

/**
 * https://leetcode.com/problems/one-edit-distance/
 */
public class OneEditDistance_161 {

    // 01/25/2021
    // first didn't use substring, wrote overcomplicated solution
    public boolean isOneEditDistance(String a, String b) {
        if (b.length() > a.length()) return isOneEditDistance(b, a);

        for (int i = 0; i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (a.length() == b.length()) return a.substring(i + 1).equals(b.substring(i + 1));
                else                          return a.substring(i + 1).equals(b.substring(i));
            }
        }
        return a.length() - b.length() == 1;
    }
}
