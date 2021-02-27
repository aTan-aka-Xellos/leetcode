package graph.medium;

/**
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnection_684 {

    // 02/27/2021
    // Had issues with find method
    public int[] findRedundantConnection(int[][] edges) {
        int[] struct = new int[edges.length + 1];
        for (int i = 1; i < struct.length; i++) struct[i] = i;

        for (int[] edge : edges) {
            if (union(struct, edge[0], edge[1])) return edge;
        }

        return new int[2];
    }


    private int findRoot(int[] struct, int node) {
        if (node == struct[node]) return node;
        struct[node] = findRoot(struct, struct[node]);
        return struct[node];
    }

    private boolean union(int[] struct, int u, int v) {
        int uRoot = findRoot(struct, u);
        int vRoot = findRoot(struct, v);
        struct[uRoot] = vRoot;

        return uRoot == vRoot;
    }
}
