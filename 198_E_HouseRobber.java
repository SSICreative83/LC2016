public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if(len == 1)    return nums[0];
        if(len == 2)    return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int maxPre = dp[0];
        
        for(int i = 2; i < len; i++) {
            dp[i] = Math.max(maxPre + nums[i], dp[i - 1]);
            maxPre = Math.max(maxPre, dp[i - 1]);
        }
        return dp[len - 1];
    }
}
