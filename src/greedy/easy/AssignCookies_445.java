package greedy.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 */
public class AssignCookies_445 {

    // 11/29/2020
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0, L = g.length - 1, R = s.length - 1;
        while (L >= 0 && R >= 0) {
            if (s[R] >= g[L]) {
                count++;
                R--;
            }
            L--;
        }
        return count;
    }

    // 07/26/2019
    public int findContentChildren_v1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int cookie = s.length - 1;
        for (int i = g.length - 1; cookie >= 0 && i >= 0; i--) {
            if (g[i] <= s[cookie]) {
                cookie--;
                count++;
            }
        }

        return count;
    }
}
