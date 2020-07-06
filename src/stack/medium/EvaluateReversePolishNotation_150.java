package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation_150 {

    public static void main(String[] args) {

        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        String operators = "+-*/";

        for (String s : tokens) {
            if (operators.contains(s)) {
                int a = stack.pop();
                int b = stack.pop();

                     if (s == "+") stack.push(b + a);
                else if (s == "-") stack.push(b - a);
                else if (s == "*") stack.push(b * a);
                else if (s == "/") stack.push(b / a);

            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }
}
