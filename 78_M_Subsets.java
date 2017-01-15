public class Solution {
    //DFS, recursion
    public List<List<Integer>> subsets1(int[] nums) {
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
        
        for(int i = start; i < nums.length; i++) {
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(nums[i]);
            dfs(i + 1, nums, ntmp, res);
        }
        
    }
    
    //Iterative
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)   return res;
        
        Arrays.sort(nums);
        List<Integer> empty = new ArrayList<>();
        res.add(empty);
        
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int curResSize = res.size();
            for(int j = 0; j < curResSize; j++) {
                List<Integer> curList = res.get(j);
                List<Integer> newList = new ArrayList<>(curList);
                newList.add(cur);
                res.add(newList);
            } 
        }
        
        return res;        
    }
}
