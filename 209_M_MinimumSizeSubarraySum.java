public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int j = 0, sum = 0, ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            while(j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if(sum >= s) {
                ans = Math.min(ans, j - i);
            } 
            sum -= nums[i]; //i is starting index, j is ending index, move starting index to right
        }
        if(ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        return ans;
    }
}
