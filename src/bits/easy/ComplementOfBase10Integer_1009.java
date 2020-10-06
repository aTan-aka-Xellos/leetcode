package bits.easy;

/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * Explanation:
 * https://leetcode.com/problems/complement-of-base-10-integer/discuss/256740/JavaC%2B%2BPython-Find-111.....1111-greater-N
 */
public class ComplementOfBase10Integer_1009 {

    public int bitwiseComplement(int N) {

        // If our result is X, then X + A = 1111...1 > N
        // then X = 1111...1 - A

        // allFirstBitsSetToOne
        int A = 1;
        while (A < N) A = (A << 1) + 1;
        return A - N; // ^ should also works
    }
}
