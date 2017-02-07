public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 1)  return res;
        List<Integer> tmp = new ArrayList<>();
        List<Integer> cand = new ArrayList<>();
        
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                cand.add(i);
            }
        }
        
        dfs(res, cand, 0, n, tmp);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> candidates, int start, int n, List<Integer> tmp) {
        int curProd = 1;
        for(int cur : tmp) {
            curProd *= cur;
        }
        if(curProd > n || start >= candidates.size()) {
            return;   
        }
        if(curProd == n && tmp.size() > 1) {
            Collections.sort(tmp);
            res.add(tmp);
            return;
        }
        
        for(int i = start; i < candidates.size(); i++) {
            int curCand = candidates.get(i);
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(curCand);
            
            //use curCand again
            dfs(res, candidates, i, n, ntmp);
        }
    }
    
}
