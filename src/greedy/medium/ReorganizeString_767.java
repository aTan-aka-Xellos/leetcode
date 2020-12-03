package greedy.medium;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/
 */
public class ReorganizeString_767 {



    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
            if (count[S.charAt(i) - 'a'] > (S.length() + 1) / 2) return "";
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            pq.add(new int[] { (i + 'a'), count[i] });
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();

            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append((char)first[0]);
                if (--first[1] > 0) pq.add(first);
            } else {
                int[] second = pq.poll();
                sb.append((char)second[0]);
                if (--second[1] > 0) pq.add(second);
                pq.add(first);
            }
        }

        return sb.toString();
    }
}
