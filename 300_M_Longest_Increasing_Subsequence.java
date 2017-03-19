public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        int[] dp = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            int maxPre = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    maxPre = Math.max(maxPre, dp[j]);
                }
            }
            dp[i] = maxPre + 1;
        }
        
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int max = 1;
        for(int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
                if(dp[i] > max) {
                    max = dp[i];
                }
            }
        }
        return max;
    }
}
