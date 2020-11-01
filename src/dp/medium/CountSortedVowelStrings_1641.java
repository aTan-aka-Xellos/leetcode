package dp.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 *
 * Weekly context 213
 */
public class CountSortedVowelStrings_1641 {

    // 11/01/2020
    public int countVowelStrings_v1(int n) {
        int[][] dp = new int[n + 1][5];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = j; k < dp[0].length; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
        return dp[n][0];
    }


    // based on: https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918498/JavaC%2B%2BPython-DP-O(1)-Space
    public int countVowelStrings_v2(int n) {
        int[] dp = {1, 1, 1, 1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[dp.length - 1];
    }


    // https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918392/Very-Easy-Solution-or-No-DP-or-No-Math-Formula-or-Solving-for-n-3-reveals-the-pattern
    public int countVowelStrings_v3(int n) {
        int ans = 0;
        for (int i = 1; i <= n + 1; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
                ans += sum;
            }
        }
        return ans;
    }




    // H(5, n) = C(5 + n - 1, n) = C(4 + n, n) = C(n + 4, 4) = (n+4) * (n+3) * (n+2) * (n+1) / 4!
    // https://en.wikipedia.org/wiki/Combination#Number_of_combinations_with_repetition
    // https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918452/C%2B%2B-1-line-mathematical-solution-with-brief-explanations
    int countVowelStrings_v4(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }

}
