package arrays.easy;

/**
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 * There is a way to solve without creating a matrix
 */
public class CellsWithOddValuesInAMatrix_1252 {

    // 11/23/2020
    public int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[][] A = new int[n][m];

        for (int[] k: indices) {
            for (int i = 0; i < m; i++) A[k[0]][i]++;
            for (int i = 0; i < n; i++) A[i][k[1]]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] % 2 == 1) count++;
            }
        }
        return count;
    }

}
