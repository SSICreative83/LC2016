
//This solution need O(n) extra space. which is not good

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; ) {
            int cur = nums[i];
            if(cur == i + 1) {  //right position
                i++;
                continue;
            }
            if(nums[cur - 1] == cur) {
                set.add(cur);
                i++;
            } else {
                swap(nums, cur - 1, i);
            }
        }
        for(Integer i: set) {
            res.add(i);
        }
        return res;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
