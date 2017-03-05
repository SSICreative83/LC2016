public class Solution {
    public int totalHammingDistance(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                int cur = nums[j];
                if(((cur >> i) & 1) == 1) {
                    count++;
                }
            }
            res += count * (nums.length - count);
        }
        return res;
    }
}
