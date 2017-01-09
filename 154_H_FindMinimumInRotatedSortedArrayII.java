public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0)    return Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        
        while(left < right && nums[left] >= nums[right]) {  //notice the condition example [1, 3, 3]
            int mid = left + (right - left) / 2;
            if(nums[left] < nums[mid]) {    //min is in right, mid can't be minimum
                left = mid + 1;
            } else if(nums[mid] < nums[right]) { // min is in left, mid could be minimum
                right = mid;
            } else {    //nums[left] == nums[mid] == nums[right], could be O(n)
                left++;
            }
            
        }
        
        return nums[left];
        
    }
}
