package string.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Longest_Common_Prefix_14 {


    public static void main(String[] args) {
        test(longestCommonPrefix(new String[]{"flower","flow","flight"}), "fl");
        test(longestCommonPrefix(new String[]{"dog","dogcat","dozz", "dqqqqqqq"}), "d");
        test(longestCommonPrefix(new String[]{"dog","dog"}), "dog");
        test(longestCommonPrefix(new String[]{"abc","abcc","abc","abca","abca"}), "abc");


        test(longestCommonPrefix(new String[]{"dog","cat"}), "");
        test(longestCommonPrefix(new String[]{"dog","racecar","car"}), "");
        test(longestCommonPrefix(new String[]{"dog","dogcat","car"}), "");
        test(longestCommonPrefix(new String[]{"dog"}), "dog");
        test(longestCommonPrefix(new String[]{}), "");
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String pref = strs[0];
        for (String s : strs) {
            while (!s.startsWith(pref)) {
                pref = pref.substring(0, pref.length() - 1);
                if (pref.isEmpty()) return pref;
            }
        }
        return pref;
    }

    public String longestCommonPrefix_2019(String[] strs) {

        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String prefix = "";

        for (int index = 0; ; index++) {
            for (int i = 1; i < strs.length; i++) {

                if (Math.min(strs[i].length(), strs[i - 1].length()) <= index
                    || strs[i].charAt(index) != strs[i - 1].charAt(index)) {
                    return prefix;
                }
            }
            prefix += strs[0].charAt(index);
        }
    }

    private static void test(String actual, String expected) {
        if (!actual.equals(expected)) throw new RuntimeException(actual + " != " + expected);
    }

}
