public class Solution {
    public int totalNQueens(int n) {
        if(n <= 0) {
            return 0;
        }
        
        int loc[] = new int[n];
        int res = dfs(n, loc, 0, 0);
        return res;
    }
    
    public int dfs(int n, int[] loc, int level, int res) {
        if(level == n) {
            return res + 1;
        }
        
        for(int i = 0; i < n; i++) {
            loc[level] = i;
            if(isValid(n, loc, level)) {
                res = dfs(n, loc, level + 1, res);
            }
        }
        
        return res;
    }
    
    public boolean isValid(int n, int[] loc, int level) {
        for(int i = 0; i < level; i++) {
            if(loc[i] == loc[level] || Math.abs(loc[level] - loc[i]) == level - i) {
                return false;
            }
        }
        return true;
    }
}
