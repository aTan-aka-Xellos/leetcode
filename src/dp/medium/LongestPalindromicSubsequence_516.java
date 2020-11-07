package dp.medium;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * With hint from @Alex
 */
public class LongestPalindromicSubsequence_516 {

    // 11/07/2020 - optimized, 21 ms, top 96%
    public int longestPalindromeSubseq(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[j][j] = 1;
            for (int i = j - 1; i >= 0; i--) {
                if (s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else              dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }



    // 11/07/2020 - first version from the whiteboard, 44 ms
    public int longestPalindromeSubseq_v1(String S) {
        int n = S.length();
        char[] s = S.toCharArray();
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (i > j) dp[i][j] = 0;
                else if (i == j) dp[i][j] = 1;
                else {
                    int max = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    dp[i][j] = dp[i + 1][j - 1];
                    dp[i][j] += s[i] == s[j] ? 2 : 0;
                    dp[i][j] = Math.max(dp[i][j], max);
                }
            }
        }
        return dp[0][n - 1];
    }
}
