public class Solution {
    //DP optimal
    public int numSquares(int n) {
        if(n <= 0) {
            return -1;
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; ++i)
            dp[i * i] = 1;

        for (int i = 0; i <= n; ++i)
            for (int j = 0; i + j * j <= n; ++j)    //need to update dp[i + j * j]
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);

        return dp[n];
       
    }    

    //DP non-optimal TLE
    public int numSquares(int n) {
        if(n <= 0) {
            return -1;
        }
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        for(int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                if(dp[j] + dp[i - j] < dp[i]) {
                    dp[i] = dp[j] + dp[i - j];
                }
            }
        }

        return dp[n];
       
    }
    
    
    // Time limit exceeded
    // Try one by one from big to small
    public int numSquares(int n) {
        
        if(n <= 0) {
            return -1;
        }
        
        return canFinish(n, 0, (int)Math.sqrt(n));
    }
    
    public int canFinish(int n, int res, int end) {
        if(n == 0) {
            return res;
        }
        
        if(n > 0 && end <= 0) { //not found
            return Integer.MAX_VALUE;
        }
        
        int result = 0;
        
        if(end * end <= n) {
            int tmpRes = res + 1;
            int newn = n - end * end;
            int res1 = canFinish(newn, tmpRes, end);    //take end
                
            int res2 = canFinish(n, res, end - 1); //not take end
            result = Math.min(res1, res2);
        } else {
            int res3 = canFinish(n, res, end - 1);
            return res3;
        }
               
        return result;
    }
}
