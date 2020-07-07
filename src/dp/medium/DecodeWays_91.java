package dp.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/decode-ways
 *
 * For optimization used solution:
 * https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
 */
public class DecodeWays_91 {

    public static void main(String[] args) {
        DecodeWays_91 d = new DecodeWays_91();
        System.out.println(d.numDecodings("11111"));
        System.out.println(d.numDecodings("12"));
        System.out.println(d.numDecodings("226"));
        System.out.println(d.numDecodings("200"));

        System.out.println(d.numDecodings("2"));
        System.out.println(d.numDecodings("0"));
        System.out.println(d.numDecodings(""));
    }

    public int numDecodings(String s) {
        int[] cache = new int[s.length() + 1];
        Arrays.fill(cache, -1);
        cache[s.length()] = 1; // to avoid check on each iteration: if (index == s.length()) return 1;
        return s.isEmpty() ? 0 : decode(s.toCharArray(), cache, 0);
    }

    int decode(char[] s, int[] cache, int i) {
        if (cache[i] > -1)  return cache[i];
        if (s[i] == '0')    return 0;

        // first case
        int sum = decode(s, cache, i + 1);

        // second case
        if (i + 1 < s.length && (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7'))) {
            sum += decode(s, cache, i + 2);
        }

        return cache[i] = sum;
    }
}
