public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if(len == 0)    return 0;
        
        //left max height
        int[] lefth = new int[len];
        lefth[0] = 0;
        for(int i = 1; i < len; i++) {
            lefth[i] = Math.max(lefth[i - 1], height[i - 1]);
        }
        
        //right max height
        int[] righth = new int[len];
        righth[len - 1] = 0;
        for(int i = len - 2; i >= 0; i--) {
            righth[i] = Math.max(righth[i + 1], height[i + 1]);
        }
        
        //calculate water
        int res = 0;
        for(int i = 0; i < len; i++) {
            int tmp = Math.min(lefth[i], righth[i]) - height[i];
            res += tmp > 0 ? tmp : 0;
        }
        return res;   
    }
}
