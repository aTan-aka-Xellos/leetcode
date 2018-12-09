package arrays.easy;

public class FindPivotIndex_724 {

    public static void main(String[] args) {
        assertEquals(pivotIndex(new int[]{}), -1);

        assertEquals(pivotIndex(new int[]{1}), 0);
        assertEquals(pivotIndex(new int[]{1, 2}), -1);
        assertEquals(pivotIndex(new int[]{1, 0}), 0);
        assertEquals(pivotIndex(new int[]{1, 2, 3}), -1);
        assertEquals(pivotIndex(new int[]{-1, 1, 3}), 2);
        assertEquals(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}), 3);
        assertEquals(pivotIndex(new int[]{-1, -1, -1, -1, 0, 1}), 1);
        assertEquals(pivotIndex(new int[]{-1, -1, -1,  0, 1, 1}), 0);
        assertEquals(pivotIndex(new int[]{-1, -1,  0,  1, 1, 0}), 5);
        assertEquals(pivotIndex(new int[]{-1, -1, -1, -1, -1, -1}), -1);

    }

    public static int pivotIndex(int[] nums) {
        int mid = 0, s1 = 0, s2 = 0;
        for (int i = mid + 1; i < nums.length; i++) s2 += nums[i];

        while (mid < nums.length - 1 && s1 != s2) {
            s1 += nums[mid++];
            s2 -= nums[mid];
        }
        if (nums.length > 0 && s1 == s2) return mid;
        return -1;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
