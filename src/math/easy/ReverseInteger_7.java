package math.easy;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger_7 {

    public static void main(String[] args) {

    }

    public int reverse(int x) {

        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs((long)x))).reverse();
        Long value = Long.parseLong(sb.toString());

        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) return 0;

        return x < 0 ? -value.intValue() : value.intValue();
    }
}
