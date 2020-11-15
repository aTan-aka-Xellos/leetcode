package prefixsum.easy;


/**
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
public class SumOfAllOddLengthSubarrays_1588 {

    // 11/13/2020
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int[] prefixSum = new int[arr.length + 1];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
            for (int j = 0; j < i; j++) {
                if ((i - j) % 2 == 1) sum += prefixSum[i] - prefixSum[j];
            }
        }
        return sum;
    }

}
