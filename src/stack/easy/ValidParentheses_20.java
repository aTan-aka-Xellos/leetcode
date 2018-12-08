package stack.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses_20 {

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') stack.push(c);

            else if (stack.empty()) return false;

            else if (c == ')' && stack.pop() != '(') return false;
            else if (c == ']' && stack.pop() != '[') return false;
            else if (c == '}' && stack.pop() != '{') return false;
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        test(isValid("()"),     true);
        test(isValid("(){}"),   true);
        test(isValid("({[]})"), true);

        test(isValid("["),    false);
        test(isValid("}"),    false);
        test(isValid("{]"),   false);
        test(isValid("{[}]"), false);
    }

    private static void test(boolean actual, boolean expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
