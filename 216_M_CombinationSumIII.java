public class Solution {
    int MAX = 9;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k < 1 || k > 9 || n < 1 || n > 45) {
            return res;
        }
        List<Integer> tmp = new ArrayList<>();
        dfs(res, tmp, k, n, 1);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> tmp, int k, int n, int start) {
        if(tmp.size() > k) {
            return;
        }
        if(tmp.size() == k) {
            int sum = 0;
            for(int i : tmp) {
                sum += i;
            }
            if(sum == n) {
                res.add(tmp);
            }
            return;
        }
        
        for(int i = start; i <= MAX; i++) {
            List<Integer> ntmp = new ArrayList<>(tmp);
            ntmp.add(i);
            dfs(res, ntmp, k, n, i + 1);
        }
    }
}
