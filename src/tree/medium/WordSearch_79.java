package tree.medium;

public class WordSearch_79 {

    public static void main(String[] args) {
        WordSearch_79 w = new WordSearch_79();

        char[][] b = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(w.exist(b, "ABCESEEDFC"));
    }


    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (explore(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    boolean explore(char[][] board, String word, int index, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] == '#' || board[i][j] != word.charAt(index))     return false;

        if (index == word.length() - 1) return true;

        char current = word.charAt(index);
        board[i][j] = '#'; // mark visited

        if (explore(board, word, index + 1, i + 1, j) ||
            explore(board, word, index + 1, i - 1, j) ||
            explore(board, word, index + 1, i, j + 1) ||
            explore(board, word, index + 1, i, j - 1))
            return true;

        board[i][j] = current; // mark unvisited
        return false;
    }

}
