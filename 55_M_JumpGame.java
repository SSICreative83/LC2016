public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len <= 1)    return true;
        
        int curFar = nums[0];
        for(int i = 0; i <= curFar; i++) {
            if(i == len - 1) {
                return true;
            }
            curFar = Math.max(curFar, i + nums[i]);
        }
        
        return false;
    }
}
