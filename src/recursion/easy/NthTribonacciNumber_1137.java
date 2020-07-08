package recursion.easy;

public class NthTribonacciNumber_1137 {

    int[] cache;

    public int tribonacci(int n) {
        if (cache == null) {
            cache = new int[n + 3];
            cache[0] = 0;
            cache[1] = 1;
            cache[2] = 1;
        }

        if (n > 2 && cache[n] == 0) {
            cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
        return cache[n];
    }

}
