package string.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning_131 {

    public static void main(String[] args) {
        PalindromePartitioning_131 p = new PalindromePartitioning_131();
        List<List<String>>  list = p.partition("aab");
        System.out.println();
    }

    public List<List<String>> partition(String s) {
        List<List<String>> global = new ArrayList<>();
        buildPalindromes(s, new LinkedList<>(), global);
        return global;
    }

    void buildPalindromes(String s, Deque<String> local, List<List<String>> global) {
        if (s.length() == 0) {
            global.add(new ArrayList(local));
            return;
        }

        int currIdx = s.length() - 1;
        while (currIdx >= 0) {
            String suff = s.substring(currIdx);
            if (isPalindrome(suff)) {
                local.addFirst(suff);
                buildPalindromes(s.substring(0, currIdx), local, global);
                local.pollFirst();
            }
            currIdx--;
        }
    }

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() >> 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

}
