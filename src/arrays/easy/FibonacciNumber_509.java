package arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/featured/card/recursion-i/255/recursion-memoization/1661
 * Solution with memoization.
 */
public class FibonacciNumber_509 {

    private Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (map.containsKey(n)) return map.get(n);

        map.put(n, _fib(n));
        return map.get(n);
    }

    private int _fib(int n) {
        if (n < 2) return n;
        return fib(n - 2) + fib(n - 1);
    }
}
