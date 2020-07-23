package backtracking.easy;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

    public static void main(String[] args) {
        LetterCasePermutation_784 l = new LetterCasePermutation_784();
        l.letterCasePermutation("abc");
    }

    List<String> global = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        generate(S, 0, "");
        return global;
    }

    void generate(String str, int index, String current) {
        if (index == str.length()) {
            global.add(current);
            return;
        }

        if (Character.isDigit(str.charAt(index))) {
            current += str.charAt(index);
            generate(str, index + 1, current);
            return;
        }

        for (int i = 0; i < 2; i++) {
            String s = String.valueOf(str.charAt(index));
            s = i % 2 == 0 ? s.toUpperCase() : s;

            current += s;
            generate(str, index + 1, current);
            current = current.substring(0, current.length() - 1);
        }
    }
}
