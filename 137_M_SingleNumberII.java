public class Solution {
    public int singleNumber(int[] nums) {
 
        int[] res = new int[32];
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for(int j = 0; j < 32; j++) {
                int curBit = (cur >> j) & 0x1;
                res[j] += curBit;
                res[j] %= 3;
            }
        }
        
        int ret = 0;
        for(int i = 0; i < 32; i++) {
            int curBit = res[i];
            ret = ret | (curBit << i);
        }
        return ret;
    }
}
