package string.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * The idea:
 * - Input string "bdсabed", result = "
 * - We know all unique letters of the answer - our alphabet: "abcde"
 *
 * - Try the smallest letter 'a'
 * - Find it's optimal (earliest) occurrence  => "bdс[a]bed"
 * - Check if the rest of the alphabet is present in the suffix after 'a', which is "bed"
 * - It's false, so answer does not starts with 'a'
 *
 * - Next alphabet is 'b' => "[b]dсabed" and the rest of the alphabet is present in the suffix
 * - Update result = "b", remove 'b' from the alphabet => "acde", new string = "dсabed"
 *
 * - Try 'a', again "bed" doesn't contains 'c'
 * - Try 'c' optimal occurrence: d[с]abed, "abed" contains the rest of the alphabet
 * - Update result = "bc", remove 'c' from the alphabet => "ade", new string = "abed"
 *
 * - Repeat until alphabet is empty
 *
 * Optimisations:
 * - Store last indexes of the each alphabet letter
 * - Test if the optimal occurrence of the chosen letter is earlier than ALL last indexes of the alphabet
 *
 * Pay attention:
 * - Since we pass substring - we need to store the last indexes from the end of the string not from the beginning
 * - define 'last' as TreeMap, not just Map - because solution relay on the order of elements inside
 *
 * Time complexity:
 * O(Aˆ2 * N + 2 * A logA), where A is the size of the alphabet, N - length of the string
 * Since A << N, the final time complexity: O(N)
 *
 * Space complexity: O(1)
 */
public class RemoveDuplicateLetters_316 {

    // Map instead of an array
    // Shorter in code but slower than array (11 ms), due to stream mostly (not effective for such small collection)
    static class V3 {

        public String removeDuplicateLetters(String s) {
            TreeMap<Character, Integer> last = new TreeMap<>();
            for (int i = 0; i < s.length(); i++) {
                last.put(s.charAt(i), s.length() - i);
            }
            return solve(s, last);
        }

        private String solve(String s, Map<Character, Integer> last) {
            for (Character c: last.keySet()) {
                int index = s.indexOf(c);
                if (last.values().stream().allMatch(x -> x <= s.length() - index)) {
                    last.remove(c);
                    return c + solve(s.substring(index + 1), last);
                }
            }
            return "";
        }
    }


    // improvement: constant time for checking substring on containing the alphabet
    // fastest version (3 ms on LeetCode)
    static class V2 {

        public String removeDuplicateLetters(String s) {
            int[] last = new int[26];
            for (int i = 0; i < s.length(); i++) {
                last[s.charAt(i) - 'a'] = s.length() - i;
            }
            return solve(s, last);
        }

        private String solve(String s, int[] last) {
            for (int i = 0; i < last.length; i++) {
                if (last[i] <= 0) continue;

                String letter = String.valueOf((char)(i + 'a'));
                int index = s.indexOf(letter);

                if (containsAll(s.length() - index, last)) {
                    last[i] = -1;
                    return letter + solve(s.substring(index + 1), last);
                }
            }
            return "";
        }

        private boolean containsAll(int currentIndex, int[] last) {
            for (int val : last) {
                if (currentIndex < val) return false;
            }
            return true;
        }
    }

    // single method, not quite readable
    static class V4 {

        TreeMap<Character, Integer> last;

        public String removeDuplicateLetters(String s) {
            if (last == null) {
                last = new TreeMap<>();
                for (int i = 0; i < s.length(); i++) {
                    last.put(s.charAt(i), s.length() - i);
                }
            }

            for (Character c: last.keySet()) {
                int index = s.indexOf(c);
                if (last.values().stream().allMatch(x -> x <= s.length() - index)) {
                    last.remove(c);
                    return c + removeDuplicateLetters(s.substring(index + 1));
                }
            }
            return "";
        }
    }


    // not optimal containsAll - it checks the whole substring for containing alphabet
    static class V1 {

        public String removeDuplicateLetters(String s) {
            Set<String> alphabet = new TreeSet<>();
            for (int i = 0; i < s.length(); i++) {
                alphabet.add(String.valueOf(s.charAt(i)));
            }
            return solve(s, alphabet);
        }

        private String solve(String s, Set<String> alphabet) {
            for (String letter: alphabet) {
                String sub = s.substring(s.indexOf(letter) + 1);
                if (containsAll(sub, alphabet, letter)) {
                    alphabet.remove(letter);
                    return letter + solve(sub, alphabet);
                }
            }
            return "";
        }

        private boolean containsAll(String sub, Set<String> alphabet, String skipValue) {
            for (String s: alphabet) {
                if (s.equals(skipValue)) continue;
                if (!sub.contains(s)) return false;
            }
            return true;
        }
    }

}
