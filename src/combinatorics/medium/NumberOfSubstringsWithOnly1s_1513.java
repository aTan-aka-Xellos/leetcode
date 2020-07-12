package combinatorics.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Contest Weekly Contest 197 - 2
 * https://leetcode.com/problems/number-of-substrings-with-only-1s/
 */
public class NumberOfSubstringsWithOnly1s_1513 {

    public int numSub(String s) {
        int total = 0;
        List<Long> counts = new ArrayList<>();

        long localLength = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                localLength++;
            } else if (localLength > 0) {
                counts.add(localLength);
                localLength = 0L;
            }
        }
        if (localLength > 0) {counts.add(localLength);}


        for (Long count : counts) {
            long sum = count * (count + 1) / 2;
            sum = sum % (1_000_000_007L);
            total += sum;
        }

        return total;
    }

}
