package random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers a, your task is to count the number of pairs i and j (where 0 ≤ i < j < a.length),
 * such that a[i] and a[j] are digit anagrams.

 * Two integers are considered to be digit anagrams if they contain the same digits.
 * In other words, one can be obtained from the other by rearranging the digits (or trivially, if the numbers are equal).
 * For example, 54275 and 45572 are digit anagrams, but 321 and 782 are not (since they don't contain the same digits).
 * 220 and 22 are also not considered as digit anagrams, since they don't even have the same number of digits.
 */
public class IntAnagrams {

    /*
    [45572]
    hash = 31 * 1

           26,439,622,160,671 // 31 ^ 9
    9,223,372,036,854,775,807 // Long max

    sum = n * (n - 1) / 2
     */

    public static void main(String[] args) {
        // expect true
        test(0, countAnagrams(new int[] {}));
        test(0, countAnagrams(new int[] {54275}));
        test(1, countAnagrams(new int[] {54275, 45572}));
        test(3, countAnagrams(new int[] {54275, 45572, 42575}));
        test(6, countAnagrams(new int[] {54275, 45572, 42575, 55427}));
        test(10, countAnagrams(new int[] {54275, 45572, 42575, 55427, 55472}));
        test(15, countAnagrams(new int[] {54275, 45572, 42575, 55427, 55472, 55724}));
        test(1, countAnagrams(new int[] {5005, 5050}));
        test(1, countAnagrams(new int[] {500700, 507000}));
        test(1, countAnagrams(new int[] {2147483647, 2144783647}));

        // expect false
        test(0, countAnagrams(new int[] {5005, 505}));
        test(0, countAnagrams(new int[] {5300, 530}));
        test(0, countAnagrams(new int[] {2147483647, 2144483647}));

        // expect true
        test(0, countAnagramsV2(new int[] {}));
        test(0, countAnagramsV2(new int[] {54275}));
        test(1, countAnagramsV2(new int[] {54275, 45572}));
        test(3, countAnagramsV2(new int[] {54275, 45572, 42575}));
        test(6, countAnagramsV2(new int[] {54275, 45572, 42575, 55427}));
        test(10, countAnagramsV2(new int[] {54275, 45572, 42575, 55427, 55472}));
        test(15, countAnagramsV2(new int[] {54275, 45572, 42575, 55427, 55472, 55724}));
        test(1, countAnagramsV2(new int[] {5005, 5050}));
        test(1, countAnagramsV2(new int[] {500700, 507000}));
        test(1, countAnagramsV2(new int[] {2147483647, 2144783647}));

        // expect false
        test(0, countAnagramsV2(new int[] {5005, 505}));
        test(0, countAnagramsV2(new int[] {5300, 530}));
        test(0, countAnagramsV2(new int[] {2147483647, 2144483647}));
    }



    public static int countAnagrams(int[] arr) {
        Map<Long, Integer> counts = new HashMap<>();

        for (int number : arr) {
            long result = convert(number);
            counts.put(result, counts.getOrDefault(result, 0) + 1);
        }

        return counts.values().stream().map(val -> val * (val - 1) / 2).mapToInt(Integer::intValue).sum();
    }

    // num = [4572, 7524]
    // convert(4572) = 31^4 + 31^5 + 31^7 + 31^2 = 27,542,167,744
    // convert(7524) = 31^7 + 31^5 + 31^2 + 31^4 = 27,542,167,744
    private static long convert(int num) {
        long B = 31;
        long hash = 0;

        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            hash += (long) Math.pow(B, digit);
        }
        return hash;
    }


    public static int countAnagramsV2(int[] arr) {
        Map<String, Integer> counts = new HashMap<>();

        for (int number : arr) {
            String asStr = convertToStr(number);
            counts.put(asStr, counts.getOrDefault(asStr, 0) + 1);
        }

        return counts.values().stream().map(val -> val * (val - 1) / 2).mapToInt(Integer::intValue).sum();
    }

    private static String convertToStr(int num) {
        int[] digits = new int[32];
        Arrays.fill(digits, -1); // work-around to fix leading zero's issue

        int pos = 0;
        while (num > 0) {
            digits[pos++] = num % 10;
            num /= 10;
        }

        Arrays.sort(digits);
        return Arrays.toString(digits); // return in form of string like "[0,0,1,3,7]"
    }

    private static void test(int expected, int actual) {
        if (expected != actual) {
            System.out.println(expected + " != " + actual);
        }
    }
}
