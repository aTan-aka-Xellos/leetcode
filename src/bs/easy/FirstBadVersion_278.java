package bs.easy;

import static java.lang.Math.abs;

import java.util.Random;

public class FirstBadVersion_278 {

    private static int RANDOM = abs(new Random().nextInt(100));

    public static void main(String[] args) {

        assertEquals(firstBadVersion(100), RANDOM);

        RANDOM = 1;
        assertEquals(firstBadVersion(1), RANDOM);
        assertEquals(firstBadVersion(10), RANDOM);

        RANDOM = 100;
        assertEquals(firstBadVersion(100), RANDOM);
    }

    public static int firstBadVersion(int n) {
        int mid, lo = 1, hi = n;
        boolean isBad;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            isBad = isBadVersion(mid);

            if (!isBad && isBadVersion(mid + 1)) return mid + 1;
            else if (!isBad) lo = mid + 1;
            else             hi = mid;
        }
        if (lo == hi && isBadVersion(lo)) return lo;
        return -1;
    }


    private static boolean isBadVersion(int n) {
        return n >= RANDOM;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
