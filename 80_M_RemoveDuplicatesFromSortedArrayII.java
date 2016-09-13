public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2)    return nums.length;
        
        int i = 2, j = i;
        for(; j < nums.length; j++) {
            if(nums[i - 2] == nums[j]) {
                continue;
            } else {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
