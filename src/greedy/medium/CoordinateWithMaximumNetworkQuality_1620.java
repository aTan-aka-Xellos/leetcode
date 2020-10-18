package greedy.medium;

/**
 * https://leetcode.com/problems/coordinate-with-maximum-network-quality/
 *
 * From the Biweekly Contest 37
 *
 * Explained by @yznovyak
 * https://pastebin.com/0cRiy5jL
 */
public class CoordinateWithMaximumNetworkQuality_1620 {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int max = -1, bestX = -1, bestY = -1;

        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int quality = 0;
                for (int[] tower : towers) {
                    double d = getDistance(i - tower[0], j - tower[1]);
                    if (d <= radius) { quality += tower[2] / (1 + d); }
                }
                if (quality > max) {
                    max = quality;
                    bestX = i;
                    bestY = j;
                }
            }
        }
        return new int[] {bestX, bestY};
    }

    double getDistance(int dx, int dy) {
        return Math.sqrt(dx * dx + dy * dy);
    }

}
