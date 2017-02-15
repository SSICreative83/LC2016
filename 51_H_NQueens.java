public class Solution {
    // time limit exceeded
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n <= 0)  return res;
        int[] loc = new int[n]; //[2, 0, 3, 1] represents Solution 2 above
        
        dfs(n, res, loc, 0);
        return res;
    }
    
    public void dfs(int n, List<List<String>> res, int[] loc, int level) {
        if(level == n) {
            addRes(n, res, loc);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            loc[level] = i;
            if(isValid(n, loc, level)) {
                dfs(n, res, loc, level + 1);   
            }
        }
    }
    
    public void addRes(int n, List<List<String>> result, int[] loc) {
        List<String> tmpArray = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            String tmp = "";
            for(int j = 0; j < n; j++){
                if(loc[i] == j){
                    tmp += "Q";
                }else{
                    tmp += ".";
                }
            }
            tmpArray.add(tmp);
        }
        
        result.add(tmpArray);
    }
    
    public boolean isValid(int n, int[] loc, int cur) {
        
        for(int i = 0; i < cur; i++){  
            if(loc[i] == loc[cur] || Math.abs(loc[i] - loc[cur]) == (cur - i)) {    //angle line will attack
                return false;  
            }
        }  
        return true; 
        
    }
}
