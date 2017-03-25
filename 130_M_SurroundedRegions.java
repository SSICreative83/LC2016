public class Solution {

// DFS, search each 'O', if found edge, then revert to O, if not, mark as 'X'
// this solution TLE

    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {    //need to do dfs
                    if(!dfs(board, i, j)) {   //not found edge
                        mark(board, 'P', 'X');
                    } else {
                        mark(board, 'P', 'O');
                    }
                }
            }
        }
    }
    
    public boolean dfs(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        
        if(row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }
        
        if(board[row][col] == 'O') {
            board[row][col] = 'P';  //in progress
        } else {
            return false;
        }
        if(row == 0 || row == m - 1 || col == 0 || col == n - 1) {  //found edge
            return true;
        }
        
        boolean foundEdge = false;
        foundEdge = dfs(board, row - 1, col) || dfs(board, row + 1, col) || dfs(board, row, col - 1) || dfs(board, row, col + 1);
        
        return foundEdge;
    }
    
    public void mark(char[][] board, char orig, char targ) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == orig) {
                    board[i][j] = targ;
                }
            }
        }
    }
   
}


// Optimized solution
public class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        if(m == 0)  return;
        int n = board[0].length;
        if(n == 0)  return;
        
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for(int j = 0; j < n; j++){
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'N'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    public void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        
        if(board[i][j] == 'O'){
            board[i][j] = 'N';
        }else{
            return;
        }
        
        //up
        if(i > 1){
            dfs(board, i - 1, j);
        }
        
        //down
        if(i < m - 2){
            dfs(board, i + 1, j);
        }
        
        //left
        if(j > 1){
            dfs(board, i, j - 1);
        }
        
        //right
        if(j < n - 2){
            dfs(board, i, j + 1);
        }
        
        return;
    }
}
