package arrays.easy;

/**
 * https://leetcode.com/problems/rotate-array/
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
public class RotateArray_189 {

    public void rotate(int[] nums, int k) {

        int count = 0;
        for (int i = 0; count < nums.length; i++) {

            int toInsert = nums[i];
            int nextPosition = i;

            do {
                nextPosition = (nextPosition + k) % nums.length;
                int temp = nums[nextPosition];
                nums[nextPosition] = toInsert;
                toInsert = temp;
            } while (++count < nums.length && nextPosition != i);
        }
    }
}
