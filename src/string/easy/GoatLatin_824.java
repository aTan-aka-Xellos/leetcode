package string.easy;

/**
 * https://leetcode.com/problems/goat-latin/
 */
public class GoatLatin_824 {


    int[] lowerCase = new int[26];

    {
        lowerCase['a' - 'a'] = 1;
        lowerCase['e' - 'a'] = 1;
        lowerCase['i' - 'a'] = 1;
        lowerCase['o' - 'a'] = 1;
        lowerCase['u' - 'a'] = 1;
    }

    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb_a = new StringBuilder("maa");

        for (String word : S.split(" ")) {
            char c = Character.toLowerCase(word.charAt(0));

            if (lowerCase[c - 'a'] == 0) {
                sb.append(word.substring(1)).append(word.charAt(0));
            } else {
                sb.append(word);
            }

            sb.append(sb_a);
            sb.append(" ");
            sb_a.append("a");
        }
        return sb.toString().trim();
    }
}
