public class Solution {
    
    // DP, O(n^2), time limit exceeded
    public int jump(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        
        int[] dp = new int[A.length];
        for(int i = 1; i < A.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(A[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[A.length - 1];
    }
}
