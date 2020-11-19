package dp.medium;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class MaximumLengthOfRepeatedSubarray_718 {

    // 11/17/2020, 93% both time and memory
    // Time: O(nm), space: O(1)
    // blame @call_zarathustra
    public int findLength_v2(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int max = 0;

        for (int i = -n + 1; i < m; i++) {
            int current = 0;
            int l = Math.max(-i, 0);
            int r = Math.min(m - i, n);

            for (int j = l; j < r; j++) {
                if (A[j] == B[j + i]) max = Math.max(max, ++current);
                else current = 0;
            }
        }
        return max;
    }

    // 11/17/2020
    public int findLength_v1(int[] A, int[] B) {
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (A[i - 1] != B[j - 1]) continue;
                
                dp[i][j] = dp[i - 1][j - 1] + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
