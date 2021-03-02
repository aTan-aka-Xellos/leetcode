package graph.medium;

/**
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class IsGraphBipartite_785 {

    // 03/02/2021
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!canSplit(color, graph, i)) return false;
        }
        return true;
    }

    private boolean canSplit(int[] color, int[][] graph, int node) {
        if (color[node] == 0) color[node] = 1;

        for (int neighbor: graph[node]) {
            if (color[neighbor] == color[node]) return false;
            if (color[neighbor] != 0) continue;

            color[neighbor] = -color[node];
            if (!canSplit(color, graph, neighbor)) return false;
        }
        return true;
    }

}
