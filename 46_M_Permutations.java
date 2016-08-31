public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)    return res;
        
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp, res);
        return res;
    }
    
    public void dfs(int[] nums, List<Integer> tmp, List<List<Integer>> res) {
        if(tmp.size() == nums.length) {
            res.add(tmp);
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(tmp.contains(cur)) {
                continue;
            }
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(cur);
            dfs(nums, ntmp, res);
        }
    }
}
