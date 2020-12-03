package twopointers.medium;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors_75 {

    // 06/12/2020, 12/01/2020 (didn't solve)
    public void sortColors(int[] nums) {
        int red = 0, white = 0, blue = nums.length - 1;

        while (white <= blue) {
                 if (nums[white] == 0) swap(nums, white++, red++);
            else if (nums[white] == 2) swap(nums, white, blue--);
            else white++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        if (a == b) return;
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }
}
