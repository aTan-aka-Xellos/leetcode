package bs.easy;

public class Sqrt_69 {

    public static void main(String[] args) {
        assertEquals(mySqrt(0), 0);
        assertEquals(mySqrt(1), 1);
        assertEquals(mySqrt(3), 1);
        assertEquals(mySqrt(4), 2);
        assertEquals(mySqrt(8), 2);
        assertEquals(mySqrt(9), 3);
        assertEquals(mySqrt(2147395599), 46339);
        assertEquals(mySqrt(2147483647), 46340);
    }


    public static int mySqrt(int x) {

        if (x == 0) return 0;
        int mid, left = 1, right = x;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            if (mid >  x / mid) right = mid;
            else                left  = mid;
        }
        return left;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
