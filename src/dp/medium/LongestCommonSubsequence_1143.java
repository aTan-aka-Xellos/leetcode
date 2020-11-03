package dp.medium;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 * https://backtobackswe.com/platform/content/longest-common-subsequence/
 * Time:  O(N*M)
 * Space: O(N*M)
 */
public class LongestCommonSubsequence_1143 {

    // 11/03/2020
    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp = new int[t1.length() + 1][t2.length() + 1];
        char[] c1 = t1.toCharArray();
        char[] c2 = t2.toCharArray();

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[c1.length][c2.length];
    }
}
