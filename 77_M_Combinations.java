public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 0 || k <= 0 || n < k)   return res;
        
        List<Integer> tmp = new ArrayList<>();
        dfs(n, k, 1, tmp, res);
        return res;
    }
    
    public void dfs(int n, int k, int start, List<Integer> tmp, List<List<Integer>> res) {
        if(tmp.size() == k) {
            res.add(tmp);
            return;
        }
        
        for(int i = start; i <= n; i++) {
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(i);
            dfs(n, k, i + 1, ntmp, res);
        }
        
    }
}
