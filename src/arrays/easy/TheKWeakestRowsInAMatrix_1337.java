package arrays.easy;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class TheKWeakestRowsInAMatrix_1337 {

    public int[] kWeakestRows(int[][] mat, int k) {

        int n = mat.length, m = mat[0].length, insertTo = 0;
        int[] weak = new int[k];

        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n && insertTo < k; row++) {
                if (mat[row][col] == 0) {
                    if (col == 0 || mat[row][col - 1] != 0) {
                        weak[insertTo++] = row;
                    }
                }
            }
        }

        for (int row = 0; row < n && insertTo < k; row++) {
            if (mat[row][m - 1] == 1) weak[insertTo++] = row;
        }
        return weak;
    }

}
