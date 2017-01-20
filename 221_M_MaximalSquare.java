public class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int row = matrix.length, col = matrix[0].length, max = 0;
        int[][] dp = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] - '0' == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
                max = Math.max(max, dp[i][0]);
            }
        }
        
        for(int j = 0; j < col; j++) {
            if(matrix[0][j] - '0' == 0) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = 1;
                max = Math.max(max, dp[0][j]);
            }
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] - '0' == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
        
    }
}
