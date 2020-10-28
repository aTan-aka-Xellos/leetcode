package dp.medium;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 *
 * Time complexity:
 * O(N*M*K)
 * where N - length of the string, M - length of the dictionary, K - avg (max?) length of the words in the dictionary
 * K appears due to string equality check
 *
 * In more general:
 * O(N^3)
 */
public class WordBreak_139 {

    // 10/28/2020 +hint from Alex
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (String word: wordDict) {
                int prevIndex = i - word.length();
                if (prevIndex >= 0 && dp[prevIndex] && !dp[i]) {
                    dp[i] = word.equals(s.substring(prevIndex, i));
                }
            }
        }
        return dp[s.length()];
    }


}
