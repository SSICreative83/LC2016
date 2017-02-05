public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        if(A == null || A.length == 0 || B == null || B.length == 0)    return null;
        int m = A.length, n = B[0].length;
        
        int[][] res = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int k = 0; k < A[0].length; k++) {  //Need to do k first, so that not need to iterate j 
                if(A[i][k] != 0) {  //exclude 0
                    for(int j = 0; j < n; j++) {
                        if(B[k][j] != 0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}
