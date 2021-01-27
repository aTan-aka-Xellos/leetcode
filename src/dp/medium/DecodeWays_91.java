package dp.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-ways
 *
 * For optimization used solution:
 * https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
 */
public class DecodeWays_91 {

    // 01/27/2021
    // struggled a lot with DP relation and indexes
    public int numDecodings_v1(String s) {
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) != '0') dp[i] = dp[i-1];

            if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) < '7')
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }


    // 07/07/2020
    public int numDecodings(String s) {
        int[] cache = new int[s.length() + 1];
        Arrays.fill(cache, -1);
        cache[s.length()] = 1; // to avoid check on each iteration: if (index == s.length()) return 1;
        return s.isEmpty() ? 0 : decode(s.toCharArray(), cache, 0);
    }

    int decode(char[] s, int[] cache, int i) {
        if (cache[i] > -1)  return cache[i];
        if (s[i] == '0')    return 0;

        // first case
        int sum = decode(s, cache, i + 1);

        // second case
        if (i + 1 < s.length && (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7'))) {
            sum += decode(s, cache, i + 2);
        }

        return cache[i] = sum;
    }
}
