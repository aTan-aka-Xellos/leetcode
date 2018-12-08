package bs.medium;

public class SearchInRotatedSortedArray_33 {


    public static void main(String[] args) {
        assertEquals(search(new int[]{1}, 1), 0);
        assertEquals(search(new int[]{1, 3}, 2), -1);

        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0), 4);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3), -1);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4), 0);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2), 6);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 100), -1);
        assertEquals(search(new int[]{4, 5, 6, 7, 0, 1, 2}, -10), -1);
    }

    public static int search(int[] nums, int target) {

        if (nums.length == 0) return -1;

        int mid, lo = 0, hi = nums.length;

        while (lo < hi) {
            mid = (hi + lo) / 2;

            System.out.println("lo: " + lo + " hi: " + hi + " mid: " + mid);

            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                     if (nums[mid] < target) lo = mid + 1;
                else if (nums[mid] > target) hi = mid;
                else return mid;
            }

            else if (target < nums[0])       lo = mid + 1;
            else                             hi = mid;
        }
        return -1;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
