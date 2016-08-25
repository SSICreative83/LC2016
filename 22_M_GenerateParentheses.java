public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)  return res;
        
        dfs(n, n, "", res);
        return res;
    }
    
    // remember the logic: if left > 0, add left parentheses; 
    // if left > right, do nothing (not valid);
    // if left < right, add right parentheses
    public void dfs(int left, int right, String tmp, List<String> res) {
        if(left == 0 && right == 0) {
            res.add(tmp);
            return;
        }
        
        if(left > 0) {
            dfs(left - 1, right, tmp + "(", res);
        }
        if(left < right) {
            dfs(left, right - 1, tmp + ")", res);
        }
        
    }
}
