//Time limit exceeded
public class Solution {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        
        int[] dp = new int[n + 1];
        if(n >= 3) {
            dp[3] = 1;
        }
        for(int i = 4; i <= n; i++) {
            int j = 2, k = i - 2;
            while(j <= k) {
                if(j * k == i - 1) {
                    break;
                } else if(j * k < i - 1) {
                    j++;
                } else {
                    k--;
                }
            }
            dp[i] = dp[i - 1];
            if(j * k != i - 1) {
                dp[i] += 1;
            }
        }
        return dp[n];
    }
}
