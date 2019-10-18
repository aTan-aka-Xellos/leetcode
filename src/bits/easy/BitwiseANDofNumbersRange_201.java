package bits.easy;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range
 */
public class BitwiseANDofNumbersRange_201 {


    public static int rangeBitwiseAnd(int m, int n) {
        int sum = 0, i = 30, mask;

        do {
            mask = 1 << i--;
            sum += mask & m;
        } while (i >= 0 && (m & mask) == (n & mask));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(0, 0) == 0);
        System.out.println(rangeBitwiseAnd(0, 1) == 0);
        System.out.println(rangeBitwiseAnd(1, 1) == 1);
        System.out.println(rangeBitwiseAnd(5, 7) == 4);
        System.out.println(rangeBitwiseAnd(1073741824, 2147483647) == 1073741824);
        System.out.println(rangeBitwiseAnd(2147483640, 2147483647) == 2147483640);
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647) == 2147483646);
        System.out.println(rangeBitwiseAnd(2147483647, 2147483647) == 2147483647);
    }

}
