package string.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning_131 {

    public static void main(String[] args) {
        PalindromePartitioning_131 p = new PalindromePartitioning_131();
        List<List<String>>  list = p.partition("aaa");
    }


    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 1) {
            result.add(new ArrayList<String>() {{add(s);}});
            return result;
        }

        if (isPalindrome(s)) {
            result.add(new ArrayList<String>() {{add(s);}});
        }

        int index = s.length() - 1;
        while(index > 0) {
            String suff = s.substring(index);
            if (isPalindrome(suff)) {
                List<List<String>> list = partition(s.substring(0, index));
                list.forEach(x -> x.add(suff));
                result.addAll(list);
            }
            index--;
        }
        return result;
    }

    /*
    ["a","a","a","a"]
    ["aa","a","a"]
    ["a","aa","a"]
    ["aaa","a"]
    ["a","a","aa"]
    ["aa","aa"]
    ["a","aaa"]
    ["aaaa"]

     10  aaaa.  => [aaaa]             self
      9  a-aaa  => [a aaa]            use 1
      8  aa-aa  => [aa aa], [a a aa]  use 2,3
      7  aaa-a  => [aa a a], [a a a a], [a aa a], [aaa a] use 4 5 6

      6  aaa    => [aaa]              self
      5  a-aa   => [a aa]             use 1
      4  aa-a   => [aa a], [a a a]    use 2,3

      3  aa     => [aa]               self
      2  a-a    => [a], [a]
      1  a      => [a]
     */

    public List<List<String>> _partition(String s) {
        List<List<String>> global = new ArrayList<>();
        buildPalindromes(s, new LinkedList<>(), global);
        return global;
    }

    void buildPalindromes(String s, Deque<String> local, List<List<String>> global) {
        if (s.length() == 0) {
            global.add(new ArrayList(local));
            return;
        }

        int currIdx = s.length();
        while (--currIdx >= 0) {
            String suff = s.substring(currIdx);
            if (isPalindrome(suff)) {
                local.addFirst(suff);
                buildPalindromes(s.substring(0, currIdx), local, global);
                local.pollFirst();
            }
        }
    }

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() >> 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

}
