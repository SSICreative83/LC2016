public class Solution {
    
    //naive approach: build an m * n array
    public int uniquePaths1(int m, int n) {
        
        int[][] result = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        
        return result[m - 1][n - 1];
    }
    
    //better: build a rolling array, size n
    public int uniquePaths(int m, int n) {
        
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                result[j] += result[j - 1];
            }
        }
        
        return result[n - 1];
    }
}
