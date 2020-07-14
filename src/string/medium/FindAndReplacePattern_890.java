package string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-and-replace-pattern/
 */
public class FindAndReplacePattern_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (word.length() != pattern.length()) continue;
            char[] toWord = new char[255];
            char[] toPatt = new char[255];

            for (int i = 0; i < word.length(); i++) {
                if (toWord[pattern.charAt(i)] == '\u0000') toWord[pattern.charAt(i)] = word.charAt(i);
                if (toPatt[word.charAt(i)]    == '\u0000') toPatt[word.charAt(i)]    = pattern.charAt(i);

                if ( toWord[pattern.charAt(i)] != word.charAt(i) || toPatt[word.charAt(i)] != pattern.charAt(i)) {
                    break;
                }

                if (i == word.length() - 1) res.add(word);
            }
        }
        return res;
    }
}
