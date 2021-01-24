package bits.medium;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
 * Weekly Contest 225
 */
public class FindKthLargestXORCoordinateValue_1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] xor = new int[m][n];

        for (int i = 0; i < m; i++) {
            int lineXor = 0;
            for (int j = 0; j < n; j++) {
                if (j > 0) lineXor ^= matrix[i][j - 1];
                if (i == 0) xor[i][j] = lineXor ^ matrix[i][j];
                if (i >  0) xor[i][j] = lineXor ^ xor[i - 1][j] ^ matrix[i][j];
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(xor[i][j]);
                if (pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }
}
