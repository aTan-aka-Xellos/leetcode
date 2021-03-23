package heap.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin_973 {

    // 03/23/2021
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        int[][] dist = new int[points.length][2];

        for (int i = 0; i < points.length; i++) {
            int d = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            dist[i][0] = d;
            dist[i][1] = i;
        }

        Arrays.sort(dist, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < k; i++) ans[i] = points[dist[i][1]];
        return ans;
    }

    // 11/29/2020
    public int[][] kClosest_v1(int[][] points, int K) {
        int[][] ans = new int[K][2];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> distance(a[0], a[1]))
        );

        pq.addAll(Arrays.asList(points));

        while (K-- > 0) {
            ans[K] = pq.poll();
        }
        return ans;
    }


    int distance(int a, int b) {
        return a*a + b*b;
        // return Math.sqrt(c);
    }


}
