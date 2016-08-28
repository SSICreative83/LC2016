public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0)    return res;
        
        //search for left bound
        int start = 0, end = nums.length - 1;
        while(start < end - 1) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                end = mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(nums[start] == target) {
            res[0] = start;
        } else  if(nums[end] == target) {
            res[0] = end;
        } else {
            res[0] = res[1] = -1;
        }
        
        //search for right bound
        start = 0;
        end = nums.length - 1;
        while(start < end - 1) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                start = mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(nums[end] == target) {
            res[1] = end;
        } else  if(nums[start] == target) {
            res[1] = start;
        } else {
            res[0] = res[1] = -1;
        }
        
        return res;
    }
}
