public class Solution {
    
    //copy value, don't need to swap values!
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int i = 0, j = i + 1;
        for(; j < nums.length; j++) {
            if(nums[j] == nums[i])  {
                continue;
            } else {
                nums[i + 1] = nums[j];
                i++;
            }
            
        }
        return i + 1;
        
    }
}
