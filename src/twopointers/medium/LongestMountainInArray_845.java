package twopointers.medium;

/**
 * https://leetcode.com/problems/longest-mountain-in-array/
 */
public class LongestMountainInArray_845 {

    // https://leetcode.com/problems/longest-mountain-in-array/discuss/271110/Easy-to-Understand-Code-O(n)
    public int longestMountain(int[] A) {
        int max = 0, i = 1, N = A.length;

        while (i < N) {
            int up = 0, down = 0;

            while (i < N && A[i - 1] < A[i]) { i++; up++;   }
            while (i < N && A[i - 1] > A[i]) { i++; down++; }

            if (up > 0 && down > 0) max = Math.max(max, up + down + 1);

            while (i < N && A[i - 1] == A[i]) i++;
        }
        return max;
    }


    // 11/16/2020 - shitty code
    public int longestMountain_v1(int[] A) {
        int max = 0, L = 0, R = 1;

        while (R < A.length) {
            if (R - L < 2) {
                R++;
            } else if (L < A.length - 1 && A[L] >= A[L+1] || A[R] == A[R-1]) {
                L++;
            } else if (A[R] < A[R-1] &&  (R == A.length - 1 || A[R] <= A[R+1])) {
                max = Math.max(max, R - L + 1);
                L = R;
            } else {
                R++;
            }
        }
        return max;
    }
}
