package math.hard;

/**
 * https://leetcode.com/problems/consecutive-numbers-sum/
 * Got help to define upper-limit from @vitar
 */
public class ConsecutiveNumbersSum_829 {

    /**
     * 01/28/2021
     * Notes:
     * - got raw formula pretty quickly
     * - failed to notice without a tip that no need to count it on each loop
     * - !!! totally missed that the upper-bound is sqrt(N)
     *
     * - missed corner case with N = 1
     * - missed the upper-bound inclusion for break condition (> vs >=)
     *
     *
     * How got formula:
     * a + b + c + d + c + ... = N
     * 5a + 1 + 2 + 3 + 4 + ... = N, because numbers are consecutive
     * k*a + sum(1 .. k-1) = N, k-1 because first number is part of k*a, k - number of ints to sum-up
     * k*a + S(k) = N
     * a = (N - S) / k, so
     * (N - S) % k == 0
     *
     *
     * How got upper-bound:
     * S = k * (k - 1) / 2
     * k * (k - 1) / 2 <= N
     * kˆ2 - k <= 2*N
     * kˆ2 <= N
     * k <= sqrt(N)
     */
    public int consecutiveNumbersSum(int N) {
        if (N == 1) return 1;

        int count = 0, sumK = 0;

        for (int k = 1; k < N; k++) {
            if ((N - sumK) % k == 0) count++;
            sumK += k;

            if (sumK >= N) break;
        }
        return count;
    }
}
