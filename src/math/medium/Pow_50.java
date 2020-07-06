package math.medium;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Pow_50 {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));

        System.out.println(Math.pow(2.00000, -2147483648));
        System.out.println(Math.pow(3.00000, 11));

    }

    // TODO: need to re-solve
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        long p = Math.abs(n);

        double power = myPow(x * x, (int) (p / 2)) * ((p % 2) == 0 ? x : 1);
        return n > 0 ? power : 1 / power;
    }
}
