public class Solution {
    //naive search O(N)
    public int searchInsertNaive(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] >= target) {
                return i;
            }
        }
        return len;
    }
    
    //binary search O(lgN)
    public int searchInsert(int[] A, int target) {
        int len = A.length;
        if(len == 0)    return 0;
        
        int start = 0;
        int end = len - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] < target){
                start = mid + 1;    //Need to skip mid
            }else{
                end = mid - 1;      //Need to skip mid
            }
        }
        
        return end + 1;
    }
}
