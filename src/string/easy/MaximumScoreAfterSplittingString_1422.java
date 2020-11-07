package string.easy;

/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */
public class MaximumScoreAfterSplittingString_1422 {

    // 11/07/2020
    public int maxScore(String s) {
        int max = 0, L = 0, R = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '1') R++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') R--;
            else                    L++;
            max = Math.max(max, R + L);
        }
        return max;
    }
}
