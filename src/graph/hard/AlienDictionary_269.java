package graph.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary_269 {


    int[] state = new int[26];
    Map<Character, Set<Character>> graph = new HashMap<>(); // TODO: new int[26][26]

    // 03/03/2021
    public String alienOrder(String[] words) {

        // collect all letters, in case if some - without edges <= TODO: could be simplified with "findEdge"?
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                graph.computeIfAbsent(word.charAt(j), k -> new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            if (!findEdge(words[i], words[i - 1])) return "";
        }

        StringBuilder sb = new StringBuilder();
        for (char character: graph.keySet()) {
            if (!dfs(sb, character)) return "";
        }
        return sb.toString();
    }

    /**
     * state = 1  -> checked and valid
     * state = -1 -> already visited, loop detected
     * state = 0  -> not checked or visited
     */
    boolean dfs(StringBuilder sb, char character) {
        if (state[character - 'a'] == -1) return false;
        if (state[character - 'a'] ==  1) return true;

        state[character - 'a'] = -1; // mark visited within this recursion

        for (char c: graph.get(character)) {
            if (!dfs(sb, c)) return false;
        }

        state[character - 'a'] *= -1; // mark finished
        sb.append(character);
        return true;
    }


    boolean findEdge(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                graph.get(s1.charAt(i)).add(s2.charAt(i));
                return true;
            }
        }
        return s1.length() >= s2.length(); // "aab", "aa" - invalid input, shorter should came first with the same prefix
    }
}
