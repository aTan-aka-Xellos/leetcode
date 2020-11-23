package greedy.medium;

/**
 * https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
 * Weekly 216
 *
 * Wasn't able to solve during whole contest (1.2h)
 */
public class SmallestStringWithAGivenNumericValue_1663 {


    public String getSmallestString(int n, int k) {
        char[] s = new char[n];

        for (int i = n - 1; i >= 0; i--) {
            int add = Math.min(k - i, 26);
            s[i] = (char)(add + 96);
            k -= add;
        }
        return new String(s);
    }

    // @kermek
    public String getSmallestString_1(int n, int k) {
        char[] ch = new char[n--];

        while (n >= 0) {
            int letter = Math.min((k - n), 26);
            k -= letter;
            ch[n--] = (char) (letter + 96);
        }
        return new String(ch);
    }

}
