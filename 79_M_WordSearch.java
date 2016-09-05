public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m == 0)  return false;
        int n = board[0].length;
        if(n == 0)  return false;
        if(word == null || word.length() == 0)  return false;
        
        char firstChar = word.charAt(0);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char cur = board[i][j];
                if(cur == firstChar) {
                    board[i][j] = ' ';  //temparily set matching position to be empty
                    if(dfs(board, i, j, word, 1)) {
                        return true;
                    }
                    board[i][j] = cur;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int row, int col, String word, int start) {
        int m = board.length;
        int n = board[0].length;
        
        if(start == word.length()) {
            return true;
        }
        
        char cur = word.charAt(start);
        
        //up
        if(row != 0 && board[row - 1][col] == cur) {
            board[row - 1][col] = ' ';
            if(dfs(board, row - 1, col, word, start + 1)) {
                return true;
            }
            board[row - 1][col] = cur;
        }
        
        //down
        if(row != m - 1 && board[row + 1][col] == cur) {
            board[row + 1][col] = ' ';
            if(dfs(board, row + 1, col, word, start + 1)) {
                return true;
            }
            board[row + 1][col] = cur;
        }
        
        //left
        if(col != 0 && board[row][col - 1] == cur) {
            board[row][col - 1] = ' ';
            if(dfs(board, row, col - 1, word, start + 1)) {
                return true;
            }
            board[row][col - 1] = cur;
        }
        
        //right
        if(col != n - 1 && board[row][col + 1] == cur) {
            board[row][col + 1] = ' ';
            if(dfs(board, row, col + 1, word, start + 1)) {
                return true;
            }
            board[row][col + 1] = cur;
        }
        
        return false;
    }
}
