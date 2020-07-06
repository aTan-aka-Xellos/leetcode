package dp.easy;

/**
 * https://leetcode.com/problems/climbing-stairs
 */
public class ClimbingStairs_70 {

    public int climbStairs(int n) {

        if (n <= 1) return n;
        int sum = 1, temp, prev = 1;

        for (int i = 2; i <= n; i++) {
            temp = sum;
            sum = sum + prev;
            prev = temp;
        }
        return sum;
    }

}
