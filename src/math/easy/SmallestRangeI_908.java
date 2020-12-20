package math.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-range-i/
 */
public class SmallestRangeI_908 {

    // 12/20/2020
    public int smallestRangeI_v1(int[] A, int K) {
        int min = Arrays.stream(A).min().orElse(0);
        int max = Arrays.stream(A).max().orElse(0);
        return Math.max(0, max - min - 2 * K);
    }

    // 12/06/2018
    public int smallestRangeI_v2(int[] A, int K) {

        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < min) min = A[i];
            if (A[i] > max) max = A[i];
        }

        int diff = max - min;
        if (diff > 2 * K) return diff - 2 * K;
        else return 0;
    }

    // 12/06/2018
    public int smallestRangeI_v3(int[] A, int K) {
        Arrays.sort(A);
        int diff = A[A.length - 1] - A[0];
        return  diff > 2 * K ? diff - 2 * K : 0;
    }

}
