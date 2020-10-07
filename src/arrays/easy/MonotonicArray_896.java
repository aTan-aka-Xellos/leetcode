package arrays.easy;

/**
 * https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray_896 {

    public boolean isMonotonic(int[] A) {
        boolean up = true, down = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) up   = false;
            if (A[i] > A[i - 1]) down = false;
        }
        return up || down;
    }
}
