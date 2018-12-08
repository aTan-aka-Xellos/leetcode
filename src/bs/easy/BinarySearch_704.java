package bs.easy;

/**
 * https://leetcode.com/explore/learn/card/binary-search/138/background/971
 */
public class BinarySearch_704 {

    public static void main(String[] args) {
        assertEquals(search(new int[]{-1,0,3,5,9,12}, 9), 4);
        assertEquals(search(new int[]{-1,0,3,5,9,12}, 2), -1);
    }

    public static int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, index;

        do {
            index = lo + (hi - lo) / 2;
            if (nums[index] == target) return index;

            if (nums[index] > target) hi = index - 1;
            else                      lo = index + 1;
        } while (lo <= hi);

        return -1;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
