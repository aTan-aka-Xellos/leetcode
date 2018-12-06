public class ProjectionAreaOf3dShapes_883 {

    public static void main(String[] args) {
        assertEquals(projectionArea(new int[][]{{2}}), 5);
        assertEquals(projectionArea(new int[][]{{1, 2}, {3, 4}}), 17);
        assertEquals(projectionArea(new int[][]{{1, 0}, {0, 2}}), 8);
        assertEquals(projectionArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}), 21);
    }


    public static int projectionArea(int[][] grid) {

        int bottom = 0, front = 0, side = 0;

        for (int i = 0; i < grid.length; i++) {
            int maxF = 0, maxS = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) bottom++;
                if (grid[i][j] > maxF) maxF = grid[i][j];
                if (grid[j][i] > maxS) maxS = grid[j][i];
            }
            front += maxF;
            side  += maxS;
        }
        return bottom + front + side;
    }

    private static void assertEquals(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
