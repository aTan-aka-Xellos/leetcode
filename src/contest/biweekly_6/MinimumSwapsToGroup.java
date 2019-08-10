package contest.biweekly_6;

/**
 * https://leetcode.com/contest/biweekly-contest-6/problems/minimum-swaps-to-group-all-1s-together
 */
public class MinimumSwapsToGroup {

    public int minSwaps(int[] data) {

        int total = 0, currentCount = 0;

        for (int datum : data) {
            if (datum == 1) total++;
        }

        for (int i = 0; i < total; i++) {
            if (data[i] == 1) currentCount++;
        }

        int max = currentCount;
        for (int i = total; i < data.length; i++) {
            if (data[i - total] == 1) currentCount--;
            if (data[i] == 1) currentCount++;
            max = Math.max(max, currentCount);
        }

        return total - max;
    }

}
