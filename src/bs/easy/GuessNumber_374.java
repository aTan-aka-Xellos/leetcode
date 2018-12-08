package bs.easy;

import static java.lang.Math.abs;

import java.util.Random;

public class GuessNumber_374 {

    private static final int RANDOM = abs(new Random().nextInt());
    private static int count = 0;

    public static void main(String[] args) {
        int found = guessNumber(Integer.MAX_VALUE);

        System.out.println();
        System.out.println("Pick:  " + RANDOM);
        System.out.println("Found: " + found);
        System.out.println("Count: " + count);

        assertEquals(found, RANDOM);
    }

    public static int guessNumber(int n) {
        int guess, mid, lo = 0, hi = n;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            System.out.println("lo: " + lo + " hi: " + hi + " mid: " + mid);
            guess = guess(mid);
            if (guess == 0) {
                return mid;
            }
            if (guess > 0) lo = mid + 1;
            else           hi = mid - 1;
        }
        return lo;
    }

    private static int guess(int guess) {
        count++;
        return Integer.compare(RANDOM, guess);
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
