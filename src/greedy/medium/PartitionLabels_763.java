package greedy.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels_763 {

    // 11/25/2020
    public List<Integer> partitionLabels(String S) {
        int[] pos = new int[26];
        char[] chars = S.toCharArray();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) pos[chars[i] - 'a'] = i;

        int count = 0, last = 0;
        for (int i = 0; i < chars.length; i++)  {
            count++;
            last = Math.max(last, pos[chars[i] - 'a']);

            if (last == i) {
                ans.add(count);
                count = 0;
            }
        }
        return ans;
    }


    // 11/25/2020
    public List<Integer> partitionLabels_v1(String S) {
        int count = 0;
        int[] pos = new int[26];
        List<Integer>  ans = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < S.length(); i++) pos[S.charAt(i) - 'a'] = i;

        for (int i = 0; i < S.length(); i++) {
            count++;

            if (pos[S.charAt(i) - 'a'] == i) set.remove(S.charAt(i));
            else                             set.add(S.charAt(i));

            if (set.isEmpty()) {
                ans.add(count);
                count = 0;
            }
        }
        return ans;
    }

}
