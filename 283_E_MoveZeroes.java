public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)    return;
        int index0 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index0] = nums[i];
                index0++;
            }
        }
        
        for(int i = index0; i < nums.length; i++) {
            nums[i] = 0;
        }        
    }
}
