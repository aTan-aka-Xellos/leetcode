package arrays.easy;

/**
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 */
public class SpecialPositionsInABinaryMatrix_1582 {

    // memory O(1)
    public int numSpecial_v2(int[][] mat) {
        int count = 0;

        for (int[] rows : mat) {
            int lastColIndex = -1;
            for (int col = 0; col < mat[0].length; col++) {
                if (rows[col] == 1) {
                    if (lastColIndex != -1) {
                        lastColIndex = -1;
                        break;
                    }
                    lastColIndex = col;
                }
            }

            if (lastColIndex == -1) continue;

            int colCount = 0;
            for (int[] _rows : mat) {
                colCount += _rows[lastColIndex];
            }
            if (colCount == 1) count++;
        }
        return count;
    }



    public int numSpecial_v1(int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }

        int count = 0;
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (mat[i][j] == 1 && col[j] == 1 && row[i] == 1) count++;
            }
        }
        return count;
    }


}
