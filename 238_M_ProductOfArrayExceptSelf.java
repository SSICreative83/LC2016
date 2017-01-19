public class Solution {
    //{              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
    //{ a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        if(nums.length == 0)    return res;
        
        left[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        
        return res;
    }
}
