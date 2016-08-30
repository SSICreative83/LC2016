public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0)    return res;
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, tmp, res);
        return res;
    }
    
    public void dfs(int[] candidates, int target, List<Integer> tmp, List<List<Integer>> res) {
        int curSum = 0;
        for(int i : tmp) {
            curSum += i;
        }
        if(curSum == target) {
            res.add(tmp);
            return;
        }
        if(curSum > target) {
            return;
        } 
        
        int curMax = Integer.MIN_VALUE;
        if(tmp.size() > 0) {
            curMax = tmp.get(tmp.size() - 1);
        }
        for(int i = 0; i < candidates.length; i++) {
            int cur = candidates[i];
            if(cur < curMax) continue;  //increasing order
            List<Integer> ntmp = new ArrayList<>();
            ntmp.addAll(tmp);
            ntmp.add(cur);
            dfs(candidates, target, ntmp, res);
        }
    }
}
