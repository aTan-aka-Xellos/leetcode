package greedy.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations
 * Time complexity: O(N logN + K + N)
 * Space complexity: O(1)
 */
public class MaximizeSumAfterKNegations_1005 {

    public int largestSumAfterKNegations(int[] A, int K) {

        Arrays.sort(A);
        int i = 0;

        while (K-- > 0) {
            A[i] = A[i] = -A[i];
            if (i + 1 < A.length && A[i + 1] < A[i])
                i++;
        }

        int sum = 0;
        for (int value : A) {
            sum += value;
        }
        return sum;
    }
}
