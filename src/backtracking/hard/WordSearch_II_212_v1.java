package backtracking.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/
 *
 * compile error count = 4
 * correctness error count = 1
 * Forgot to restore the original state (board[i][j] ^= 256) if the word was found
 * In the WordSearch_79, only single word is searched and state restore is not needed.
 *
 *
 * This is not optimal solution, it't not utilize smth like Prefix Tree.
 */
public class WordSearch_II_212_v1 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < board.length && !found; i++) {
                for (int j = 0; j < board[0].length && !found; j++) {
                    if (find(board, word.toCharArray(), 0, i, j)) {
                        result.add(word);
                        found = true;
                    }
                }
            }
        }
        return result;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};


    /**
     * Time complexity:
     * O(W * M*N * 3ˆL), W - number of words, M*N - size of the board, L - length of the word (avg?)
     */
    boolean find(char[][] board, char[] word, int index, int i, int j) {
        if (index == word.length) return true;
        if (i < 0 || i == board.length || j < 0 || j == board[0].length) return false;
        if (board[i][j] != word[index]) return false;

        board[i][j] ^= 256;

        for (int k = 0; k < 4; k++) {
            if (find(board, word, index + 1, i + dx[k], j + dy[k])) {
                board[i][j] ^= 256;
                return true;
            }
        }

        board[i][j] ^= 256;
        return false;
    }
}
