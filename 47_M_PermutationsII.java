public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)    return res;
        
        List<Integer> tmp = new ArrayList<>();
        List<Integer> nnums = new ArrayList<>();
        Arrays.sort(nums);
        for(int i: nums) {
            nnums.add(i);
        }

        dfs(nnums, tmp, res);
        return res;
    }
    
    public void dfs(List<Integer> nums, List<Integer> tmp, List<List<Integer>> res) {
        if(nums.size() == 0) {
            res.add(tmp);
            return;
        }
        
        for(int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(cur);
            List<Integer> nnums = new ArrayList<>(nums);
            nnums.remove(i);
            dfs(nnums, ntmp, res);
            while(i < nums.size() - 1 && nums.get(i) == nums.get(i + 1)) i++;
        }
        
    }
}
