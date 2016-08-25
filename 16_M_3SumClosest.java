public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int dist = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            
            for(int j = i + 1, k = nums.length - 1; j < k && j < nums.length && k >= 0;) {
                int tmp = Math.abs(target - nums[i] - nums[j] - nums[k]);
                if(tmp < dist) {
                    dist = tmp;
                    res = nums[i] + nums[j] + nums[k];
                }
                
                if(nums[i] + nums[j] + nums[k] <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}
