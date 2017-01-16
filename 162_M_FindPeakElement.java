public class Solution {
    //O(n)
    public int findPeakElement1(int[] nums) {
        
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
    
    //O(logn)
    public int findPeakElement(int[] nums) {
        
        int len = nums.length;
        if(len == 0)    return -1;
        if(len == 1)    return 0;
        if(nums[0] > nums[1])   return 0;
        if(nums[len - 1] > nums[len - 2])   return len - 1;
        
        int start = 1;
        int end = len - 2;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if(nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                start = mid;
            }
            
        }
        
        if(nums[start] > nums[start + 1] && nums[start] > nums[start - 1]) {
            return start;
        } else if(nums[end] > nums[end + 1] && nums[end] > nums[end - 1]) {
            return end;
        }
        
        return -1;
    }
}
