import java.util.Arrays;

public class SmallestRangeI {

    public static void main(String[] args) {

        assertEquals(smallestRangeI(new int[]{1}, 0), 0);
        assertEquals(smallestRangeI(new int[]{0, 10}, 2), 6);
        assertEquals(smallestRangeI(new int[]{1, 3, 6}, 3), 0);
        assertEquals(smallestRangeI(new int[]{2, 7, 2}, 1), 3);

        assertEquals(smallestRangeIShort(new int[]{1}, 0), 0);
        assertEquals(smallestRangeIShort(new int[]{0, 10}, 2), 6);
        assertEquals(smallestRangeIShort(new int[]{1, 3, 6}, 3), 0);
        assertEquals(smallestRangeIShort(new int[]{2, 7, 2}, 1), 3);
    }

    public static int smallestRangeI(int[] A, int K) {

        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) min = A[i];
            if (A[i] > max) max = A[i];
        }

        int diff = max - min;
        if (diff > 2 * K) return diff - 2 * K;
        else return 0;
    }

    public static int smallestRangeIShort(int[] A, int K) {
        Arrays.sort(A);
        int diff = A[A.length - 1] - A[0];
        return  diff > 2 * K ? diff - 2 * K : 0;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
