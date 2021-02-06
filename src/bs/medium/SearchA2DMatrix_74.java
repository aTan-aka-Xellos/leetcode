package bs.medium;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int L = 0, R = row * col;

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            int[] pos = getXY(col, mid);

            if (matrix[pos[0]][pos[1]] > target) R = mid;
            else                                 L = mid;
        }

        int[] pos = getXY(col, L);
        return matrix[pos[0]][pos[1]] == target;
    }


    private int[] getXY(int col, int mid) {
        int[] pos = new int[2];
        pos[0] = mid / col;
        pos[1] = mid % col;
        return pos;
    }

}
