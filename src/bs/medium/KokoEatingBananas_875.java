package bs.medium;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas_875 {

    // 02/03/2021
    // - confused what to return: L or R
    // - confused < and <=
    public int minEatingSpeed(int[] piles, int H) {
        int L = 0, R = 1_000_000_000;

        while (R - L > 1) {
            int mid = (L + R) >>> 1;
            if (canEat(mid, piles, H)) R = mid;
            else                       L = mid;
        }
        return R;
    }

    boolean canEat(int eat, int[] piles, int H) {
        int hours = 0;
        for (int pile: piles) {
            hours += (pile + eat - 1) / eat;
        }
        return hours <= H;
    }


}
