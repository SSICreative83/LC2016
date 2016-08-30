public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return res;
        
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, tmp, res);
        return res;
    }
    
    public void dfs(int[] candidates, int target, int start, List<Integer> tmp, List<List<Integer>> res) {
        int curSum = 0;
        for(int i : tmp) {
            curSum += i;
        }
        if(curSum == target) {
            res.add(tmp);
            return;
        }
        if(curSum > target) return;
        
        for(int i = start; i < candidates.length; i++) {
            int cur = candidates[i];
            
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(cur);
            
            dfs(candidates, target, i + 1, ntmp, res);
            
            while(i < candidates.length - 1 && candidates[i + 1] == candidates[i]) i++;
        }
        
    }
}
