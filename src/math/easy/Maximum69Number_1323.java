package math.easy;

/**
 * https://leetcode.com/problems/maximum-69-number/
 */
public class Maximum69Number_1323 {

    // 11/25/2020
    public int maximum69Number (int num) {
        int rem = num, add = 0, pos = 1;

        while (rem > 0) {
            if (rem % 10 == 6) add = pos;
            rem /= 10;
            pos *= 10;
        }
        return num + 3 * add;
    }

}
