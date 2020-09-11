package arrays.medium;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class Spiral_Matrix_II_59 {

    public int[][] generateMatrix(int n) {
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int [][] res = new int[n][n];

        int count = 0, m = 0;
        int col = 0, row = 0;

        while (count < n * n) {
            if (col < 0 || row < 0 || col == n || row == n || res[col][row] != 0) {
                col -= moves[m][0];
                row -= moves[m][1];
                m = (m == 3) ? 0 : m + 1;

                col += moves[m][0];
                row += moves[m][1];
            }
            res[col][row] = ++count;

            col += moves[m][0];
            row += moves[m][1];
        }
        return res;
    }

}
