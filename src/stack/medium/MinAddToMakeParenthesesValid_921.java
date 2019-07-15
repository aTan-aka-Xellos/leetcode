package stack.medium;

import java.util.Stack;

/**
 * Review:
 * https://youtu.be/prUE1gPsJ-g?t=36
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class MinAddToMakeValid_921 {

    /**
     * With stack;
     */
    public int minAddToMakeValid(String S) {

        int result = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') stack.push('(');
            else {
                if (stack.isEmpty()) result++;
                else stack.pop();
            }
        }
        return result + stack.size();
    }

    /**
     * Without stack.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 34.1 MB, less than 100.00% of Java online submissions.
     */
    public int minAddToMakeValidWithoutStack(String S) {
        
        int result = 0;
        int open = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') open++;
            else {
                if (open == 0) result++;
                else open--;
            }
        }
        return result + open;
    }

}
