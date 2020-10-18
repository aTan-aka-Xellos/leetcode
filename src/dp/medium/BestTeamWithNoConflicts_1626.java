package dp.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-team-with-no-conflicts/
 *
 * From the Weekly Contest 211
 *
 * Explained by Alex
 * https://pastebin.com/a6TuX29p
 *
 *
 * Idea:
 * - sort by age and score (to avoid extra handling when age is the same)
 * - store in dp[i] the best possible team score for i player
 *
 * - for each i player, check:
 *  - if the score of younger player j is less or equals to the current score:
 *      - if it's team score (with i-score) better than the current best dp[i] team score
 *          - then assign new best score to dp[i]
 *
 */
public class BestTeamWithNoConflicts_1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length, max = 0;
        int[] dp = new int[n];
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            data[i][0] = ages[i];
            data[i][1] = scores[i];
        }

        Arrays.sort(data, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            dp[i] = data[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (data[j][1] <= data[i][1]) {
                    dp[i] = Math.max(dp[i], data[i][1] + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
