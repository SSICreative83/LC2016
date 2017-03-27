public class Solution {
    //bottom up
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
    
    //DP top to bottom: self 
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int level = triangle.length;
        int[][] sum = new int[level][level];
        sum[0][0] = triangle[0][0];
        for(int i = 1; i < level; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    sum[i][j] = sum[i - 1][j] + triangle[i][j];
                    continue;
                }
                if(j == i) {
                    sum[i][j] = sum[i - 1][j - 1] + triangle[i][j];
                    continue;
                } 
                sum[i][j] = triangle[i][j] + Math.min(sum[i - 1][j - 1], sum[i - 1][j]);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i : sum[level - 1]) {
            res = Math.min(res, i);
        }
        return res;
    }
    
  //DP: same as above
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int[][] dp = new int[triangle.size()][triangle.size()];
        
        dp[0][0] = triangle.get(0).get(0);
        for(int row = 1; row < triangle.size(); row++) {
            dp[row][0] = dp[row - 1][0] + triangle.get(row).get(0);
            dp[row][row] = dp[row - 1][row - 1] + triangle.get(row).get(row);
        }
        for(int row = 1; row < triangle.size(); row++) {
            List<Integer> curRow = triangle.get(row);
            for(int col = 1; col < row; col++) {
                int curNum = curRow.get(col);
                dp[row][col] = Math.min(dp[col - 1][col - 1], dp[col - 1][col]) + curNum;
            }
        }
        
        int res = dp[triangle.size() - 1][0];
        for(int k = 1; k < triangle.size(); k++) {
            res = Math.min(res, dp[triangle.size() - 1][k]);
        }
        
        return res;
    }
    

} 
