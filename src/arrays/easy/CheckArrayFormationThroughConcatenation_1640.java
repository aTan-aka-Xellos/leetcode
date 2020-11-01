package arrays.easy;

/**
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 *
 * Weekly context 213
 */
public class CheckArrayFormationThroughConcatenation_1640 {

    // 11/01/2020
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int[] piece: pieces) {

            // find the index of occurrence the piece[0]
            int index = 0;
            while (index < arr.length && piece[0] != arr[index]) {
                index++;
            }

            for (int i = 0; i < piece.length; i++, index++) {
                if (index >= arr.length || piece[i] != arr[index]) return false;
            }
        }
        return true;
    }
}
