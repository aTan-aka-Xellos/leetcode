package dp.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/longest-string-chain/
 * https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues/1410 <= blame @call_zarathustra
 */
public class LongestStringChain_1048 {

    // 11/21/2020
    public int longestStrChain(String[] words) {
        int max = 0;
        int[] dp = new int[words.length];
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0 && words[i].length() - words[j].length() <= 1; j--) {
                if (isPredecessor(words[i], words[j]))
                    if (dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
            }
            if (max < dp[i]) max = dp[i];
        }
        return max + 1; // add the last word itself to the chain length
    }

    // compare each char of two words, until the diff exceed 1
    boolean isPredecessor(String w1, String w2) {
        if (w1.length() - w2.length() != 1) return false;

        int L = 0, R = 0; // pointers for each word
        while (L < w1.length() && R < w2.length() && L - R <= 1) {
            if (w1.charAt(L) == w2.charAt(R)) R++;
            L++;
        }
        return L - R <= 1; // if the char at the end, diff will be 0 and it's Ok
    }

}
