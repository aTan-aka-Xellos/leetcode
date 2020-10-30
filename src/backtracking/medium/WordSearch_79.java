package backtracking.medium;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Usage NOR instead of storing local var is taken from:
 * https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.
 *
 * Idea to use dx, dy - suggested by Alex
 *
 * Time complexity: O(N*3^min(L, N))
 */
public class WordSearch_79 {

    // rules for the next step
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // 10/29/2020 - when solved again, forgot where mark visited and didn't properly read the task
    // 08/01/2020
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (explore(board, word.toCharArray(), 0, i, j)) return true;
            }
        }
        return false;
    }


    boolean explore(char[][] board, char[] word, int index, int i, int j) {
        if (index == word.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word[index]) return false;

        board[i][j] ^= 256; // mark visited

        for (int k = 0; k < 4; k ++) {
            if (explore(board, word, index + 1, i + dx[k], j + dy[k])) return true;
        }

        board[i][j] ^= 256; // mark unvisited
        return false;
    }

}
