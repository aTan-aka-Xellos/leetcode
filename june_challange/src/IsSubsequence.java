public class IsSubsequence {

    // O(s + t)
    public boolean isSubsequence(String s, String t) {

        int cursor = 0;
        for (int i = 0; cursor < s.length() && i < t.length(); i++) {

            if (t.charAt(i) == s.charAt(cursor)) {
                cursor++;
            }
        }
        return cursor == s.length();
    }
}
