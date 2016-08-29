public class Solution {
    public void solveSudoku(char[][] board) {
        solveHelper(board);
    }
    
    public boolean solveHelper(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if(cur != '.') {
                    continue;
                } 
                for(int k = 1; k <= 9; k++) {
                    board[i][j] = (char)(k + '0');
                    if(isValidSudoku(board, i, j) && solveHelper(board)) {  //current position, then recursion
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board, int a, int b) {
    
        HashSet<Character> set = new HashSet<>();
        //row
        for(int i = 0; i < 9; i++) {
            char cur = board[a][i];
            if(cur == '.') {
                continue;
            }
            if(cur - '0' > 9 || cur - '0' < 1 || set.contains(cur)) {
                return false;
            }
            set.add(cur);
        }
        
        //column
        set.clear();
        for(int i = 0; i < 9; i++) {
            char cur = board[i][b];
            if(cur == '.') {
                continue;
            }
            if(set.contains(cur)) {
                return false;
            }
            set.add(cur);
        }
        
        //subset
        set.clear();
        int i = a / 3;
        int j = b / 3;
                for(int k = 0; k < 3; k++) {
                    for(int h = 0; h < 3; h++) {
                        char cur = board[i * 3 + k][j * 3 + h];
                        if(cur == '.') {
                            continue;
                        }
                        if(set.contains(cur)) {
                            return false;
                        }
                        set.add(cur);
                    }
                }
                
        return true;        
    }
}
