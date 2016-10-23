public class Solution {
    public int findPeakElement(int[] nums) {
        
        int len = nums.length;
        if(len == 0)    return -1;
        if(len == 1)    return 0;
        
        for(int i = 0; i < len; i++) {
            if(i == 0 && nums[0] > nums[1]) {
                return 0;
            } else if(i == 0) {
                continue;
            } else if(i == len - 1 && nums[len - 1] > nums[len - 2]) {
                return len - 1;
            } else if(i == len - 1) {
                continue;
            } else if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        
        return -1;
    }
}
