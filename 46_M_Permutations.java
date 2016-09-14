public class Solution {
    //recursion, DFS
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)    return res;
        
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        List<Integer> nnums = new ArrayList<>();
        for(int i : nums) {
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
            List<Integer> nnums = new ArrayList<>(nums);
            nnums.remove(i);
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(cur);
            dfs(nnums, ntmp, res);
        }
    }
    
    //Iterative
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)    return res;
        if(nums.length == 1) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[0]);
            res.add(tmp);
            return res;
        }
        
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            
            int[] nnums = new int[nums.length - 1];
            for(int j = 0; j < nums.length; j++) {
                if(j == i)  continue;
                if(j < i) {
                    nnums[j] = nums[j];
                } else {
                    nnums[j - 1] = nums[j];
                }
            }
            
            List<List<Integer>> cres = permute(nnums);
            for(List<Integer> clist : cres) {
                clist.add(cur);
                res.add(clist);
            }
        }
        return res;
    }
}
