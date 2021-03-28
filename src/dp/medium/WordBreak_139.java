package dp.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // 28/03/2021
    // O(20 * 20 * N)
    // 20 - substring, 20 - contains, N - iterations
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int max = 20;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= max && j <= i; j++) {
                if (!dp[i - j]) continue;

                String sub = s.substring(i - j, i);
                if (set.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // 10/28/2020 +hint from Alex
    public boolean wordBreak_v1(String s, List<String> wordDict) {
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
