package dp.medium;

/**
 * https://leetcode.com/problems/2-keys-keyboard/
 * Discussed with @Alex
 */
public class AKeysKeyboard_650 {


    /**
     * 12/11/2020
     *
     * Had issues with:
     *  - index borders (j*j < i), because of dp[i] = i
     *  - tried to add +1, but it's already part if (i/j)
     *  - missed 'break'
     *  - tried extra check for dp[j] + (i/j)
     *  - wasn't sure about dp dimension (if need to store current buffer)
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                    break;
                }
            }
        }
        return dp[n];
    }
}
