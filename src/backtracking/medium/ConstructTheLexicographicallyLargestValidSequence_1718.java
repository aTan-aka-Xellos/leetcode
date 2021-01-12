package backtracking.medium;

/**
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
 * Biweekly Contest 43
 */
public class ConstructTheLexicographicallyLargestValidSequence_1718 {


    // 01/11/2021
    // Haven't solved during contest
    // Issues:
    // - struggled with finding ending condition
    // - passed extra parameters
    // - confused corner cases (with idx)
    public int[] constructDistancedSequence(int n) {
        int[] ans  = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];

        bt(n, 0, used, ans);
        return ans;
    }

    private boolean bt(int n, int idx, boolean[] used, int[] ans) {
        while (idx < ans.length &&  ans[idx] > 0) idx++;
        if (idx == ans.length) return true;

        for (int i = n; i > 0; i--) {
            if (used[i]) continue;
            if (i != 1 && (idx + i >= ans.length || ans[idx + i] > 0)) continue;

            // set
            used[i] = true;
            ans[idx] = i;
            if (i != 1) ans[idx + i] = i;

            // dive
            if (bt(n, idx + 1, used, ans)) return true;

            // backtrack
            used[i] = false;
            ans[idx] = 0;
            if (i != 1) ans[idx + i] = 0;
        }
        return false;
    }
}
