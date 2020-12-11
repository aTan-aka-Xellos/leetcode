package stack.easy;

/**
 * https://leetcode.com/problems/remove-outermost-parentheses/
 *
 * The optimal solution from @Lee215
 * https://leetcode.com/problems/remove-outermost-parentheses/discuss/270022/JavaC%2B%2BPython-Count-Opened-Parenthesis
 */
public class RemoveOutermostParentheses_1021 {

    // 12/11/2020
    // haven't used SB right away
    public String removeOuterParentheses(String S) {
        char[] s = S.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder primitive = new StringBuilder();
        int count = 0;

        for (char ch : s) {
            if (ch == '(') count++;
            else           count--;

            primitive.append(ch);

            if (count == 0) {
                res.append(primitive.substring(1, primitive.length() - 1));
                primitive.setLength(0);
            }
        }
        return res.toString();
    }

}
