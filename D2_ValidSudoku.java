public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9) {
            return false;
        }
    
        HashSet<Character> set = new HashSet<>();
        //row
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if(cur == '.') {
                    continue;
                }
                if(cur - '0' > 9 || cur - '0' < 1 || set.contains(cur)) {
                    return false;
                }
                set.add(cur);
            }
            set.clear();
        }
        
        //column
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char cur = board[j][i];
                if(cur == '.') {
                    continue;
                }
                if(set.contains(cur)) {
                    return false;
                }
                set.add(cur);
            }
            set.clear();
        }
        
        //subset
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
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
                set.clear();
            }
        }
    
        return true;        
    }
}
