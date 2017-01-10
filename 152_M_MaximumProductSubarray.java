public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)    return 0;
        
        int max = nums[0], maxEndHere = nums[0], minEndHere = nums[0], minEndHereCur = nums[0], maxEndHereCur = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            minEndHereCur = Math.min(Math.min(nums[i], nums[i] * maxEndHere), nums[i] * minEndHere);
            maxEndHereCur = Math.max(Math.max(nums[i], nums[i] * maxEndHere), nums[i] * minEndHere);
            max = Math.max(max, maxEndHereCur);
            minEndHere = minEndHereCur;
            maxEndHere = maxEndHereCur;
        }
        
        return max;
    }
}
