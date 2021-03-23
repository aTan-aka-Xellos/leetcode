package stack.easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * 03/23/2021
 */
public class ImplementQueueUsingStacks_232 {

    Stack<Integer> in  = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
        return out.pop();
    }

    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
        return out.peek();
    }

    public boolean empty() {
        return out.isEmpty() && in.isEmpty();
    }

}
