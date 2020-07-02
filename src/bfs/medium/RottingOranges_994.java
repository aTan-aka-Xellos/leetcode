package bfs.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RottingOranges_994 {

    public int orangesRotting(int[][] grid) {
        int count = 0;
        int countFresh = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i,j});
                if (grid[i][j] == 1) countFresh++;
            }
        }
        if (countFresh == 0) return 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] orange = queue.poll();
                List<int[]> list = getNeighbors(orange[0], orange[1], grid);
                list.forEach(queue::add);
                countFresh -= list.size();

            }
            count++;


        }
        return countFresh == 0 ? count - 1 : -1;
    }

    List<int[]> getNeighbors(int i, int j, int[][] grid) {
        List<int[]> list = new LinkedList<>();
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        if ((i - 1 >= 0) && grid[i-1][j] == 1) list.add(new int[]{i-1, j});
        if ((j - 1 >= 0) && grid[i][j-1] == 1) list.add(new int[]{i, j-1});

        if ((i + 1 < rowLength) && grid[i+1][j] == 1)    list.add(new int[]{i+1, j});
        if ((j + 1 < columnLength) && grid[i][j+1] == 1) list.add(new int[]{i, j+1});

        list.forEach((x) -> {grid[x[0]][x[1]] = 2;});
        return list;
    }

}
