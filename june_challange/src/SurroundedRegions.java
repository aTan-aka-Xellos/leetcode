import java.util.Stack;

public class SurroundedRegions {

    int n, m;

    public void solve(char[][] board) {
        if (board.length == 0) return;
        n = board.length;
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (board[i][j] != 'O') {continue;}
                    markNeighbors(i, j, board);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }


    void markNeighbors(int i, int j, char[][] board) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});

        while (!stack.isEmpty()) {
            int[] c = stack.pop();
            i = c[0];
            j = c[1];
            if (board[i][j] == 'S') {continue;}

            board[i][j] = 'S';
            if (j + 1 < m  && board[i][j + 1] == 'O') stack.push(new int[]{i, j + 1});
            if (j - 1 >= 0 && board[i][j - 1] == 'O') stack.push(new int[]{i, j - 1});
            if (i + 1 < n  && board[i + 1][j] == 'O') stack.push(new int[]{i + 1, j});
            if (i - 1 >= 0 && board[i - 1][j] == 'O') stack.push(new int[]{i - 1, j});
        }
    }
}
