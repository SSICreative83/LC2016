public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)   return res;
        
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, tmp, res);
        List<Integer> empty = new ArrayList<>();
        res.add(empty);
        return res;        
    }
    
    public void dfs(int start, int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if(tmp.size() > 0) {
            res.add(tmp);
        }
        
        for(int i = start; i < nums.length; ) {
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(nums[i]);
            dfs(i + 1, nums, ntmp, res);
            i++;
            while(i < nums.length && nums[i] == nums[i - 1]) i++;   //notice the condition
        }
        
    }
}
