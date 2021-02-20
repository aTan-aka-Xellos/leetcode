package string.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/
 */
public class NumberOfDistinctSubstringsInAString_1698 {


    // O(N^2), @vital
    // 02/20/2021
    public int countDistinct_v3(String s) {
        long B = 31;
        Set<Long> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            long hash = 0;
            for (int j = i; j < s.length(); j++) {
                hash = hash * B + s.charAt(j) - 'a' + 1;
                set.add(hash);
            }
        }
        return set.size();
    }


    // O(N^3), @vital
    // 02/20/2021
    public int countDistinct_v2(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();

        for (int i = 0; i < n; i ++) {
            String t = "";
            for (int j = i; j < n; j ++) {
                t += s.charAt(j);
                set.add(t);
            }
        }
        return set.size();
    }



    // O(N^3)
    // 02/18/2021
    public int countDistinct_v1(String s) {
        Set<String> set = new HashSet<>();
        set.add("");

        while (!s.isEmpty()) {
            genPrefix(s, set);
            s = s.substring(1);
        }
        return set.size() - 1;
    }

    void genPrefix(String s, Set<String> set) {
        while (!set.contains(s)) {
            set.add(s);
            s = s.substring(0, s.length() - 1);
        }
    }
}
