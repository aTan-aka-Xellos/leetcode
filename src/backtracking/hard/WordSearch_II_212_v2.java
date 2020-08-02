package backtracking.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * compile error count = 4
 * correctness error count = 1 (accidentally used j instead of i in the validation)
 *
 */
public class WordSearch_II_212_v2 {


    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    Node root = new Node();
    Set<String> globalResult = new HashSet<>(); // to avoid duplicates


    /**
     * Time complexity:
     * O(W * avg(L)) - adding words to the Tree
     * (N*M * 3ˆL) - for each cell, we do max 3ˆL checks (each one is O(1), because of using current node)
     */
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word.toCharArray());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                explore(board, root, i, j, "");
            }
        }
        return new ArrayList<>(globalResult);
    }


    void explore(char[][] board, Node node, int i, int j, String prefix) {
        if (i < 0 || j >= board.length || j < 0 || j >= board[0].length) return;

        char currentLetter = board[i][j];
        node = node.get(currentLetter); // get child node by letter we currently explore
        if (node == null) return;

        prefix += currentLetter; // need this string to add to the final result
        board[i][j] ^= 256; // mark visited

        if (node.isWord) {
            globalResult.add(prefix);
        }

        for (int k = 0; k < 4; k++) {
            explore(board, node, i + dx[k], j + dy[k], prefix);
        }

        board[i][j] ^= 256; // un-mark visited
    }



    void insert(char[] word) {
        Node current = root;
        for (char ch : word) {
            current = current.addIfNull(ch);
        }
        current.isWord = true;
    }

    static class Node {
        boolean isWord = false;
        Node[] children = new Node[26];

        Node addIfNull(char ch) {
            int index = ch - 'a';
            if (children[index] == null) children[index] = new Node();
            return children[index];
        }

        Node get(char ch) {
            if (ch > 'z') return null; // visited cell will have a value higher due to (ˆ256) operation
            int index = ch - 'a';
            return children[index];
        }
    }

}
