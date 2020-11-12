package math.easy;

/**
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class SubtractProductAndSumOfDigits_1281 {

    // 11/12/2020
    public int subtractProductAndSum(int n) {
        int a = 1, b = 0;

        while (n > 0) {
            a *= n % 10;
            b += n % 10;
            n /= 10;
        }
        return a - b;
    }
}
