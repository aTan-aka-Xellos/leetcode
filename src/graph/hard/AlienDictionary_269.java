package graph.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary_269 {


    int[][] map = new int[26][26];

    public String alienOrder(String[] words) {

        // point on itself, need for letters without edges
        for (String w : words) {
            for (int j = 0; j < w.length(); j++) {
                map[w.charAt(j) - 'a'][w.charAt(j) - 'a'] = 2;
            }
        }

        for (int i = 1; i < words.length; i++) {
            if (!findEdges(words[i], words[i - 1])) return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            if (map[i][i] == 0) continue;
            if (!dfs(sb, i)) return "";
        }
        return sb.toString();
    }

    /**
     * map = 2  -> edge present in the string,
     * map = 1  -> checked and valid
     * map = 0  -> not checked or visited
     * map = -1 -> already visited, loop detected
     */
    boolean dfs(StringBuilder sb, int i) {
        if (map[i][i] == -1) return false;
        if (map[i][i] ==  1) return true;
        map[i][i] = -1; // mark visited, but not finished within this recursion

        for (int j = 0; j < 26; j++) {
            if (map[i][j] == 0 || j == i) continue;
            if (!dfs(sb, j)) return false;
        }

        map[i][i] = 1; // mark finished
        sb.append((char)(i + 'a'));
        return true;
    }

    boolean findEdges(String s1, String s2) {
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                map[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = 2;
                return true;
            }
        }
        // "aab", "aa" - invalid input, shorter should came first with the same prefix
        return s1.length() >= s2.length();
    }
}
