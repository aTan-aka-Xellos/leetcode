package design.medium;

/**
 * https://leetcode.com/problems/flatten-2d-vector/
 * Amazon (source: chat)
 *
 * Missed too much corner cases, solved by running code too much.
 */
public class Flatten2DVector_251 {

    // 11/04/2020
    static class Vector2D {

        int[][] v;
        int r, c;

        public Vector2D(int[][] v) {
            this.v = v;
        }

        public int next() {
            hasNext();
            return v[r][c++];
        }

        public boolean hasNext() {
            while (r < v.length && c == v[r].length) {
                c = 0;
                r++;
            }
            return r < v.length && c < v[r].length;
        }
    }
}
