package string.easy.medium;

import java.util.Stack;

public class ReverseWordsInString_151 {

    /**
     * First accepted solution. Not the most optimal one due:
     * - stack
     * - trim
     * - concatenation
     */
    public String reverseWords(String s) {

        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                stack.push(s.charAt(i));
            } else {
                while (!stack.isEmpty()) {
                    result += stack.pop();
                }
                if (!result.endsWith(" ")) {
                    result += " ";
                }
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result.trim();
    }
}
