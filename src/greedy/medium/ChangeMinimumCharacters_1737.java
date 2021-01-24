package greedy.medium;

/**
 * https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/
 * Weekly Contest 225
 * With a tip from @Alex
 */
public class ChangeMinimumCharacters_1737 {

    public int minCharacters(String a, String b) {
        return Math.min(min(a, b), min(b, a));
    }

    int min(String a, String b) {
        int[] aCount = new int[26];
        int[] bCount = new int[26];

        for (char c: a.toCharArray()) aCount[c - 'a'] += 1;
        for (char c: b.toCharArray()) bCount[c - 'a'] += 1;

        int min = Integer.MAX_VALUE;
        for (int split = 1; split < 26; split++) {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                if (i >= split) sum += aCount[i];
                else            sum += bCount[i];
            }
            min = Math.min(min, sum);
        }

        for (int split = 0; split < 26; split++) {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                if (i != split) {
                    sum += aCount[i];
                    sum += bCount[i];
                }
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}
