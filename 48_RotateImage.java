public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n <= 1) return;
        
        for(int i = 0; i < n / 2; i++){
            //layer is i
            
            for(int j = i; j <= n - i - 2; j++){
                
                //difficulty is calculating offset
                //int offset = j - i;
                
                int tmp = matrix[i][j];
                
                //bottom left -> top left
                matrix[i][j] = matrix[n - 1 - j][i];
                
                //bottom right -> bottom left
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                
                //top right -> bottom right
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                
                //top left -> to right
                matrix[j][n - 1 - i] = tmp;
                
            }
        }
        
    }
}
