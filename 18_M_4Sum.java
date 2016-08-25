public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 3; ) {
            for(int j = i + 1; j < nums.length - 2; ) {
                int newTarget = target - nums[i] - nums[j];
                
                for(int k = j + 1, h = nums.length - 1; k < h && k < nums.length - 1 && h >= 0; ) {
                    if(nums[k] + nums[h] == newTarget) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[h]);
                        res.add(tmp);
                        
                        k = inc(nums, k);
                        h = dec(nums, h);
                    } else if(nums[k] + nums[h] < newTarget) {
                        k = inc(nums, k);
                    } else {
                        h = dec(nums, h);
                    }
                }
                
                j = inc(nums, j);
            }
            i = inc(nums, i);
        }
        
        return res;
    }
    
    public int inc(int[] nums, int i) {
        i++;
        while(i < nums.length && nums[i] == nums[i - 1])    i++;
        return i;
    }
    
    public int dec(int[] nums, int i) {
        i--;
        while(i >= 0 && nums[i] == nums[i + 1])    i--;
        return i;
    }
}
