package arrays.easy;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 *
 * Sort in-place.
 */
public class SortArrayByParity_905 {

    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1;

        while (l < r) {
            while (l < r && (A[l] & 1) != 1) l++;
            while (l < r && (A[r] & 1) != 0) r--;
            swap(A, l++, r--);
        }
        return A;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
