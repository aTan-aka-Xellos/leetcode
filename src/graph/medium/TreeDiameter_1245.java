package graph.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/tree-diameter/
 */
public class TreeDiameter_1245 {

    /**
     * 02/26/2021
     * Issues:
     * - edge-to-graph transformation
     * - extra loop to count the number of nodes
     * - extra parameters in the method (2)
     * - bug with assigning maxEdge (missed result returned by bfs
     */
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] distA = new int[n];
        int edgeA = bfs(graph, distA, 0);

        int[] distB = new int[n];
        int edgeB = bfs(graph, distB, edgeA);
        return distB[edgeB];
    }

    int bfs(List<List<Integer>> graph, int[] dist, int current) {
        int maxEdge = 0;
        for (int node: graph.get(current)) {
            if (dist[node] > 0) continue;
            dist[node] = dist[current] + 1;

            int maxChildEdge = bfs(graph, dist, node);
            if (dist[maxEdge] < dist[maxChildEdge]) maxEdge = maxChildEdge;
            if (dist[maxEdge] < dist[node])         maxEdge = node;
        }
        return maxEdge;
    }

}
