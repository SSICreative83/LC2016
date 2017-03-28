public class Solution {
    int GTD = 2;
    int GTL = -1;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0 && numLive(board, i, j) == 3) {
                    board[i][j] = GTL;
                    continue;
                }
                if(board[i][j] == 1 && (numLive(board, i, j) < 2 || numLive(board, i, j) > 3)) {
                    board[i][j] = GTD;
                    continue;
                }
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == GTL) {
                    board[i][j] = 1;
                    continue;
                }
                if(board[i][j] == GTD) {
                    board[i][j] = 0;
                    continue;
                }
            }
        }
        
    }
    
    public int numLive(int[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        
        int count = 0;
        if(row != 0) {
            count += (board[row - 1][col] >= 1) ? 1 : 0;
        }
        if(row != m - 1) {
            count += (board[row + 1][col] >= 1) ? 1 : 0;
        }
        if(col != 0) {
            count += (board[row][col - 1] >= 1) ? 1 : 0;
        }
        if(col != n - 1) {
            count += (board[row][col + 1] >= 1) ? 1 : 0;
        }
        if(row != 0 && col != 0) {
            count += (board[row - 1][col - 1] >= 1) ? 1 : 0;
        }
        if(row != 0 && col != n - 1) {
            count += (board[row - 1][col + 1] >= 1) ? 1 : 0;
        }
        if(row != m - 1 && col != 0) {
            count += (board[row + 1][col - 1] >= 1) ? 1 : 0;
        }        
        if(row != m - 1 && col != n - 1) {
            count += (board[row + 1][col + 1] >= 1) ? 1 : 0;
        }
        return count;
    }
}
