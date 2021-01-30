package bs.easy;

import static java.lang.Math.abs;

import java.util.Random;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion_278 {

    private static int RANDOM = abs(new Random().nextInt(100));

    public static void main(String[] args) {

        assertEquals(firstBadVersion(100), RANDOM);
        assertEquals(firstBadVersion_simple(100), RANDOM);

        RANDOM = 1;
        assertEquals(firstBadVersion(1),  RANDOM);
        assertEquals(firstBadVersion(10), RANDOM);
        assertEquals(firstBadVersion_simple(1),  RANDOM);
        assertEquals(firstBadVersion_simple(10), RANDOM);

        RANDOM = 100;
        assertEquals(firstBadVersion(100),        RANDOM);
        assertEquals(firstBadVersion_simple(100), RANDOM);
    }

    // 01/30/2021
    public int firstBadVersion_v2(int n) {
        int L = 0, R = n;

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (isBadVersion(mid)) R = mid;
            else                   L = mid;
        }
        return R;
    }

    // 12/09/2018
    public static int firstBadVersion(int n) {
        int mid, lo = 1, hi = n;

        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid) && isBadVersion(mid + 1)) return mid + 1;
            else if (!isBadVersion(mid)) lo = mid + 1;
            else             hi = mid;
        }
        if (lo == hi && isBadVersion(lo)) return lo;
        return -1;
    }

    public static int firstBadVersion_simple(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else                   left = mid + 1;
        }
        return left;
    }

    private static boolean isBadVersion(int n) {
        return n >= RANDOM;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
