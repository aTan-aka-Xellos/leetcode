package bs.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays_1011 {

    // 01/29/2021
    public int shipWithinDays_v1(int[] weights, int D) {
        int L = 0;
        for (int w: weights) {
            L = Math.max(L, w);
        }
        int R = L * weights.length / D;

        while (L < R) {
            int mid = (L + R) >>> 1;
            if (canShip(weights, D, mid)) R = mid;
            else                          L = mid + 1;
        }
        return L;
    }

    boolean canShip_v1(int[] weights, int D, int cap) {
        int load = 0;
        for (int weight : weights) {
            if (load + weight > cap) {
                D--;
                load = 0;
            }
            load += weight;
        }
        return D > 0;
    }

    // 01/28/2021
    public int shipWithinDays(int[] weights, int D) {
        int sum = Arrays.stream(weights).sum();
        int L = 1, R = sum;

        while (L < R) {
            int mid = (L + R) >>> 1;
            if (canShip(weights, D, mid)) R = mid;
            else                          L = mid + 1;
        }
        return L;
    }

    boolean canShip(int[] weights, int D, int capacity) {
        int i = 0;
        while (D-- > 0) {
            int loaded = 0;
            for (; i < weights.length && loaded + weights[i] <= capacity; i++) {
                loaded += weights[i];
            }
        }
        return i == weights.length;
    }

}
