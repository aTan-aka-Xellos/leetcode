package arrays.easy;

/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 */
public class FindLuckyIntegerInAnArray_1394 {

    public int findLucky(int[] arr) {
        int max = -1;
        int[] count = new int[500];
        for (int a: arr) count[a]++;

        for (int i = 1; i < count.length; i++) {
            if (count[i] == i) max = Math.max(max, i);
        }
        return max;
    }
}
