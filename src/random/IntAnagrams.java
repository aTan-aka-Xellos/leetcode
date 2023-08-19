package random;

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
    long B = 31;
    long hash = 0;
    hash = hash * B + s.charAt(j) - 'a' + 1;

    [45572]

    hash = 31 * 1

           26,439,622,160,671 // 31 ^ 9
    9,223,372,036,854,775,807 // Long max

    sum = n * (n - 1) / 2

     */

    public static void main(String[] args) {
        System.out.println(0 ==  countAnagrams(new int[] {}));
        System.out.println(0 ==  countAnagrams(new int[] {54275}));
        System.out.println(1 ==  countAnagrams(new int[] {54275, 45572}));
        System.out.println(3 ==  countAnagrams(new int[] {54275, 45572, 42575}));
        System.out.println(6 ==  countAnagrams(new int[] {54275, 45572, 42575, 55427}));
        System.out.println(10 == countAnagrams(new int[] {54275, 45572, 42575, 55427, 55472}));
        System.out.println(15 == countAnagrams(new int[] {54275, 45572, 42575, 55427, 55472, 55724}));
    }


    public static int countAnagrams(int[] arr) {
        Map<Double, Integer> counts = new HashMap<>();

        for (int number : arr) {
            double hash = getHash(number);
            counts.put(hash, counts.getOrDefault(hash, 0) + 1);
        }

        return counts.values().stream().map(val -> val * (val - 1) / 2).mapToInt(Integer::intValue).sum();
    }

    // num = [4572]
    // hash = 31^4 + 31^5 + 31^7 + 31^2
    private static double getHash(int num) {
        long B = 31;
        double hash = 0;

        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            hash += Math.pow(B, digit);
        }
        return hash;
    }

}
