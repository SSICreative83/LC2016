public class Solution {
    public int search(int[] nums, int target) {
        
        if(nums.length == 0)    return -1;
        
        int start = 0, end = nums.length - 1;
        while(start < end - 1) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[start] < nums[mid]) {    //left is increasing
                if(nums[start] <= target && nums[mid] >= target) {  //target in left
                    end = mid;
                } else {
                    start = mid;
                }
            } else {    //right is increasing
                if(nums[mid] <= target && nums[end] >= target) {    //target in right
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if(nums[start] == target) {
            return start;
        }else if(nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}
