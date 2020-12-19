package string.easy;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare_844 {

    // 12/17/2020
    // Issues:
    // - tried to use single loop for both strings
    // - haven't thought of corner cases ahead of time
    // - started coding without understanding the algorithm
    public boolean backspaceCompare(String S, String T) {
        return bs(S).equals(bs(T));
    }

    String bs(String s) {
        int i = -1;
        StringBuilder sb = new StringBuilder();

        while (++i < s.length()) {
            if (s.charAt(i) == '#') sb.setLength(sb.length() == 0 ? 0 : sb.length() - 1);
            else                    sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // 12/17/2020
    // Haven't used | in the regex
    public boolean backspaceCompare_v1(String S, String T) {
        while (S.contains("#")) S = S.replaceAll("[a-z]#|^#", "");
        while (T.contains("#")) T = T.replaceAll("[a-z]#|^#", "");

        return S.equals(T);
    }
}
