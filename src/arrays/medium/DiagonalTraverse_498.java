package arrays.medium;

public class DiagonalTraverse_498 {


    public static int[] findDiagonalOrder(int[][] matrix) {
        int xMax = matrix.length - 1;
        int yMax = matrix[0].length - 1;
        int[] result = new int[(xMax + 1) * (yMax + 1)];

        int x = 0, y = 0;

        for (int i = 0; i < (xMax + 1) * (yMax + 1); i ++) {
            result[i] = matrix[x][y];

            if ((x + y) % 2 == 0) {
                if (y == yMax) { x++; }
                else if (x == 0)    { y++; }
                else                { x--; y++; }
            } else {
                if (x == xMax) { y++; }
                else if (y == 0)    { x++; }
                else                { x++; y--; }
            }
        }

        return result;
    }

}
