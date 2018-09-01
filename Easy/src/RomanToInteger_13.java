/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger_13{

    public static void main(String[] args) {

        test(romanToInt("III"), 3);
        test(romanToInt("IV"), 4);
        test(romanToInt("IX"), 9);
        test(romanToInt("LVIII"), 58);

        test(romanToInt("MCMXCIV"), 1994);
    }

    public static int romanToInt(String s) {

        int result  = 0;
        int current = 0;
        int prev    = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') current = 1;   else
            if (s.charAt(i) == 'V') current = 5;   else
            if (s.charAt(i) == 'X') current = 10;  else
            if (s.charAt(i) == 'L') current = 50;  else
            if (s.charAt(i) == 'C') current = 100; else
            if (s.charAt(i) == 'D') current = 500; else
            if (s.charAt(i) == 'M') current = 1000;

            if (prev >= current) result += prev;
            else
                result -= prev;

            if (i + 1 == s.length()) result += current;

            prev = current;
        }

        return result;
    }

    private static void test(int actual, int expected) {
        if (actual != expected) System.err.println(actual + " != " + expected);
    }
}
