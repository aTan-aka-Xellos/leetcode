package segmenttree.medium;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

public class RangeSumQueryMutable_307 {


    private int numberOfBlocks;
    private long[] blocks;
    private int[] stationCount;

    public RangeSumQueryMutable_307(int[] stationCount) {
        this.stationCount = stationCount;

        numberOfBlocks = (int) (Math.sqrt(stationCount.length) + 1);
        blocks = new long[numberOfBlocks];

        for (int i = 0; i < stationCount.length; i++) {
            blocks[i / numberOfBlocks] += stationCount[i];
        }
    }

    public void update(int i, int val) {
        blocks[i / numberOfBlocks] -= stationCount[i];
        stationCount[i] = val;
        blocks[i / numberOfBlocks] += stationCount[i];
    }


    public int sumRange(int left, int right) {
        int sum = 0;
        int leftBlockIndex = left / numberOfBlocks;
        int rightBlockIndex = right / numberOfBlocks;

        if (leftBlockIndex == rightBlockIndex) {
            for (int i = left; i <= right; i++) {
                sum += stationCount[i];
            }
            return sum;
        }


        // leftBlock, numberOfBlocks = number of items in the block (sqrt)
        int endOfLeftBlock = (leftBlockIndex + 1) * numberOfBlocks - 1;
        for (int i = left; i <= endOfLeftBlock; i++) {
            sum += stationCount[i];
        }

        // rightBlock, numberOfBlocks = number of items in the block (sqrt)
        int startOfRightBlock = (rightBlockIndex) * numberOfBlocks;
        for (int i = startOfRightBlock; i <= right; i++) {
            sum += stationCount[i];
        }

        // between
        for (int i = leftBlockIndex + 1; i < rightBlockIndex; i++) { // check <=
            sum += blocks[i];
        }
        return sum;
    }

}
