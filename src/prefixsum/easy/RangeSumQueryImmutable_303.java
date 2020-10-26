package prefixsum.easy;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable_303 {

    int[] prefixSum;

    public RangeSumQueryImmutable_303(int[] nums) {
        prefixSum = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    public int sumRange(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }

}
