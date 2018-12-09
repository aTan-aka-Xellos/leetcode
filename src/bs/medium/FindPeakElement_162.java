package bs.medium;

public class FindPeakElement_162 {

    public static void main(String[] args) {
        assertEquals(findPeakElement(new int[]{1, 2, 3, 1}), 2);
        assertEquals(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}), 1);
        assertEquals(findPeakElement(new int[]{1, 10, 3, 4, 5, 6, 7, 8, 9, 10}), 1);
    }

    public static int findPeakElement(int[] nums) {

        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }
        return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
