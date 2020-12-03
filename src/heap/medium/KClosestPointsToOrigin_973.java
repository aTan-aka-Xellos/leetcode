package heap.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin_973 {

    // https://leetcode.com/problems/k-closest-points-to-origin/

    public int[][] kClosest(int[][] points, int K) {
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
