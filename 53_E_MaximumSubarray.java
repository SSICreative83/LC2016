public class Solution {
    //self
     public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxEndingHere = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if(maxEndingHere > 0) {
                maxEndingHere += cur;
            } else {
                maxEndingHere = cur;
            }
            
            res = Math.max(res, maxEndingHere);
        }
        
        return res;
    }
    
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int curSum = 0;
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            
            if(curSum < 0) {  //here curSum is sum of previous values, not include current 
                curSum = 0;
            } 
            curSum += cur;
            res = Math.max(res, curSum);
        }
        
        return res;
    }
}
