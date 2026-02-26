class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        return backtrack(n, board, 0);
    }
    public int backtrack(int n, char[][] board, int row) {
        if (row == n) {
            return 1;
        }
        int cnt = 0;
        for (int col = 0; col < n; col++) {
            if (valid(board, row, col)) {
                board[row][col] = 'Q';
                cnt += backtrack(n, board, row + 1);
                board[row][col] = '.';  
            }
        }
        return cnt;
    }
    public boolean valid(char[][] board, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}