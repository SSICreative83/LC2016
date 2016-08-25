public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; ) {
            int newTarget = -1 * nums[i];
            
            for(int j = i + 1, k = len - 1; j < k && j < len && k >= 0;) {
                if(nums[j] + nums[k] == newTarget) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                    
                    j++;
                    while(j < len && nums[j] == nums[j - 1])    j++;
                    k--;
                    while(k >= 0 && nums[k] == nums[k + 1])     k--;
                } else if (nums[j] + nums[k] < newTarget) {
                    j++;
                } else if (nums[j] + nums[k] > newTarget) {
                    k--;
                }
            }
            
            i++;
            while(i < len && nums[i] == nums[i - 1])    i++;
        }
        return res;
    }
}
