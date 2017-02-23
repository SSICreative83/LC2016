public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)    return 0;
        
        int i = 0, j = nums.length - 1;
        while( i < j ) {
            if(nums[i] != val) {
                i++;
                continue;
            }
            if(nums[j] == val) {
                j--;
                continue;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        
        if(nums[i] == val) {
            return i;
        } else {
            return i + 1;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    
    //done by self
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)    return 0;
        
        int i = 0, j = nums.length - 1;
        for(; i < j; ) {

            if(nums[j] == val ) {
                j--;
                continue;
            }
            if(nums[i] != val) {
                i++;
                continue;
            }
            
            swap(nums, i, j);
        }
    
        if(nums[i] == val) {
            return i;
        } else {
            return i + 1;
        }
    }
}
